import java.util.Random;

public class guessTheNumber {
    final int HIGH_BOUND = 100;
    final int LOW_BOUND = 1;
    final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Random rand = new Random();

        int targetNumber = rand.nextInt(MAX_ATTEMPTS);
    }
}