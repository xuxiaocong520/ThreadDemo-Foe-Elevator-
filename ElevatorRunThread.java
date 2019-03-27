package ThreadDemo;

public class ElevatorRunThread implements Runnable {

	  private Elevator elevator;

	    public ElevatorRunThread(Elevator elevator) {
	        this.elevator = elevator;
	    }

	    @Override
	    public void run() {
	        System.out.println("Truning on,Do Working!");
	        //产生waiter的线程
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                //每10秒产生一个waiter
	                while (true) {
	                    try {
	                        Thread.sleep(5000);
	                    } catch (Exception e) {}
	                    elevator.addWaiter(
	                            new Waiter(RandomUtil.getRandomInt(10) + 1,
	                                    RandomUtil.getRandomInt(2, 19), false));
	                }
	            }
	        }).start();

	        while (true) {
	             try {
	                 Thread.sleep(1000);
	                 elevator.run();
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }
	    }


}