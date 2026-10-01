import domain.AccountBanker;
import domain.AccountManager;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    private static AccountBanker accountAccess;

    public static void main(String[] args) {
        AccountManager acess = new AccountManager();
        String acessNumber;
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        do {
            System.out.println(" 1 - Create a account \n 2 - deposit \n 3 - withdraw \n 4 - transfer \n 5 - consult balance \n 6 - exit");
            int answer = input.nextInt();
            switch (answer) {
                case 1:
                    System.out.println("type your name: ");
                    String name = input.next();
                    System.out.println("type your number: ");
                    String number = input.next();
                    acess.addAccount(name,number);
                    break;
                case 2:
                    System.out.println("type your number: ");
                    acessNumber = input.next();
                    System.out.println("How much do you want to deposit?");
                    BigDecimal numberDeposit = input.nextBigDecimal();
                    acess.deposit(acessNumber,numberDeposit);
                    break;
                case 3:
                    System.out.println("type your number: ");
                    acess.getContas().get(input.next());
                    System.out.println("How much do you want to withdraw?");
                    acess.withdraw(input.nextBigDecimal());
                    break;
                case 4:
                    System.out.println("Enter the account number you want to deposit into: ");
                    acess.getContas().get(input.next());
                    System.out.println("deposit amount: ");
                    acess.transfer(accountAccess, input.nextBigDecimal());
                    break;
                case 5:
                    System.out.println(acess.toString());
                    break;
                default:
                    finished = true;
            }
        } while (!finished);

    }




}
