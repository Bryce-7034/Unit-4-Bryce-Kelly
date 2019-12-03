import java.util.Scanner;

public class BankAccountTester {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        BankAccount bank;
        String username;
        String password;
        double moneyIn;
        double moneyOut;
        System.out.println("Would you like to keep running (y/n)");
        if (scan.nextLine().equals("n")){
            run = false;
        }
        System.out.println("What is your Username");
        username = scan.nextLine();
        System.out.println("What is your Password");
        password = scan.nextLine();
        System.out.println("How much money do you start with");
        moneyIn = scan.nextDouble();
        bank = new BankAccount(username, password, moneyIn);
    }
}
