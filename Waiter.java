package ThreadDemo;

public class Waiter {

	  private int num;

	    private int targetFloor;

	    private int currentFloor;

	    private boolean isToUp;

	    public Waiter(int targetFloor, int currentFloor, boolean isToUp) {
	        this.targetFloor = targetFloor;
	        this.currentFloor = currentFloor;
	        this.isToUp = isToUp;
	        this.num = ConstUtil.getIndex();
	    }

	    public int gettargetFloor() {
	        return targetFloor;
	    }

	    public void settargetFloor(int targetFloor) {
	        this.targetFloor = targetFloor;
	    }

	    public int getCurrentFloor() {
	        return currentFloor;
	    }

	    public void setCurrentFloor(int currentFloor) {
	        this.currentFloor = currentFloor;
	    }


		public boolean isToUp() {
	        return isToUp;
	    }

	    public void setToUp(boolean toUp) {
	        isToUp = toUp;
	    }

	 
	    public Taker toTaker() {
	        return new Taker(num, targetFloor);
	    }

	    @Override
	    public String toString() {
	        return "Waiter{" +
	                "num= " + num +
	                ", targetFloor=" + targetFloor +
	                ", currentFloor=" + currentFloor +
	                ", isToUp=" + isToUp +
	                '}';
	    }
}
