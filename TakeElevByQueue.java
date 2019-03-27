package ThreadDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TakeElevByQueue implements Elevator {

	/**
	 * taker队列
	 */
	private BlockingQueue<Taker> takersQueue;

	/**
	 * waiter队列
	 */
	private BlockingQueue<Waiter> waitersQueue;

	/**
	 * 电梯当前配送对象
	 */
	private Taker currentTaker;

	/**
	 * 电梯当前层
	 */
	private int currentFloor = 2;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (takersQueue.isEmpty()) {
			System.out.println("No one at the Evevator");
			synchronized (waitersQueue) {
				if (waitersQueue.isEmpty()) {
					System.out.println("No one Waiting");
					try {
						waitersQueue.wait();
					} catch (InterruptedException e) {
					}
				} else {
					// 去waiter所在层
					Waiter firstWaiter = waitersQueue.poll();
					toFloor(firstWaiter.getCurrentFloor());
					System.out.println(firstWaiter + " get in ");
					takersQueue.add(firstWaiter.toTaker());
				}
			}
		} else {
			currentTaker = takersQueue.poll();
			toFloor(currentTaker.getTargetFloor());
			System.out.println(currentTaker + "arriving ");
		}

	}

	@Override
	public void addTaker(Taker taker) {
		// TODO Auto-generated method stub
		synchronized (takersQueue) {
			System.out.println(taker + " take in ");
			takersQueue.add(taker);
		}
	}

	@Override
	public void addWaiter(Waiter waiter) {
		// TODO Auto-generated method stub
		synchronized (waitersQueue) {
			System.out.println("Waitting for the Elevator: " + waiter);
			waitersQueue.add(waiter);
			waitersQueue.notifyAll();
		}

	}

	public TakeElevByQueue() {
		waitersQueue = new LinkedBlockingQueue<>();
		takersQueue = new LinkedBlockingQueue<>();
	}

	private synchronized void toFloor(int targetFloor) {
		try {
			while (currentFloor < targetFloor) {
				Thread.sleep(1000);
				System.out.println("Elevator arrive at " + currentFloor);
				currentFloor++;
			}
			while (currentFloor > targetFloor) {
				Thread.sleep(1000);
				System.out.println("Elevator arrive at  " + currentFloor);
				currentFloor--;
			}
			System.out.println("Elevator arrive at the " + targetFloor + "Floor");
			// 当前电梯口有没有等待者，有就直接上电梯
			
			
			synchronized (waitersQueue) {
				BlockingQueue<Waiter> tmpWaitersQueue = new LinkedBlockingQueue<>();
				while (!waitersQueue.isEmpty()) {
					Waiter waiter = waitersQueue.poll();
					if (waiter.getCurrentFloor() == currentFloor) {
						addTaker(waiter.toTaker());
					} else {
						tmpWaitersQueue.add(waiter);
					}
				}
				waitersQueue.addAll(tmpWaitersQueue);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
