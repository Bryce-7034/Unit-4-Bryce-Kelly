public class DieTester {
    public static void main(String[] args) {
        System.out.println("Welcome to the dice simulator");

        Die die1 = new Die();
        Die die2 = new Die();

        System.out.println("Die 1 is " + die1.toString());
        System.out.println("Die 2 is " + die2.toString());

        die1.roll();
        die2.roll();

        System.out.println("Die 1 is now "+ die1.toString());
        System.out.println("Die 2 is now "+ die2.toString());
    }

}
