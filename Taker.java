package ThreadDemo;

public class Taker {

	/**
	 * 将waiter变成taker
	 *
	 * @return
	 */
    private int targetFloor;
    private int num;
	
    public Taker(int num, int targetFloor) {
        this.num = num;
        this.targetFloor = targetFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }


	@SuppressWarnings("unused")
	private void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taker)) return false;

        Taker taker = (Taker) o;

        return getTargetFloor() == taker.getTargetFloor();
    }

    @Override
    public int hashCode() {
        return getTargetFloor();
    }

    @Override
    public String toString() {
        return "Taker{" +
                " num=" + num +
                ", targetFloor=" + targetFloor +
                "}";
    }
}
