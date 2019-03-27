package ThreadDemo;

public class ConstUtil {
	

    private static int index = 0;

    public static int getIndex() {
        index++;
        return index;
    }

}
