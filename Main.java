package ThreadDemo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Thread(new ElevatorRunThread(new TakeElevByQueue())).start();
	}

}
