package ThreadDemo;

public interface Elevator {
    int MAX_FLOOR = 20;

    int MIN_FLOOR = 1;

    int MAX_SIZE = 10;

    void run();

    void addTaker(Taker taker);

    void addWaiter(Waiter waiter);
}

