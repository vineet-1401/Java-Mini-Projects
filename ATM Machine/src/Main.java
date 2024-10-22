
import java.util.*;

class ATM {
    Scanner sc = new Scanner(System.in);
    private float Balance;
    int PIN = 1234;

    public void menu() {
        System.out.println("Enter your choice: ");
        System.out.println("1. Check Balance. ");
        System.out.println("2. WithDraw. ");
        System.out.println("3 Deposit. ");
        System.out.println("4 EXIT. ");
        int enteredChoice = sc.nextInt();
        switch (enteredChoice) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.println("Enter amount to withdraw: ");
                float amount = sc.nextFloat();
                withdrawAmount(amount);
                break;
            case 3:
                System.out.println("Enter amount to deposit: ");
                float depositAmount = sc.nextFloat();
                depositAmount(depositAmount);
                break;
            case 4:
                break;
            default:
                System.out.println("Enter a valid choice");

        }
    }

    public void checkBalance() {
        System.out.println("Your bank balance is " + "" + Balance);
        menu();
    }

    public void withdrawAmount(float amount) {
        if (this.Balance >= amount) {
            this.Balance -= amount;
            System.out.println("Amount withdraw successful.");
        } else {
            System.out.println("Insufficient Balance.");

        }
        menu();
    }

    public void depositAmount(float amount) {
        this.Balance += amount;
        System.out.println("Amount deposit successful.");
        menu();
    }

    public void checkPin() {
        System.out.println("Enter your Pin: ");
        int enteredPin = sc.nextInt();
        if (this.PIN == enteredPin) {
            menu();
        } else {
            System.out.println("Enter a valid Pin");
            checkPin();
        }
    }


}

class Main {
    public static void main(String[] args) {
        ATM obj1 = new ATM();
        obj1.checkPin();
        

    }
}
