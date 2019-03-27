package ThreadDemo;

import java.util.Random;

public class RandomUtil {
	
	   private static Random random = new Random();

	    public static int getRandomInt(int max) {
	        return random.nextInt(max + 1);
	    }

	    public static int getRandomInt(int min, int max) {
	        return min + getRandomInt(max);
	    }

	    public static boolean getRandomBool() {
	        return random.nextBoolean();
	    }


}
