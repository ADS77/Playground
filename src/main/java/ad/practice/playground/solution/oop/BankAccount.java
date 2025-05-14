package ad.practice.playground.solution.oop;

public class BankAccount {
    private  double balance;

    public BankAccount( double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public static void main(String[]a){
        BankAccount ba = new BankAccount(10000);
        //System.out.println(ba.balance);
        ba.deposit(5000);;
        System.out.println(ba.balance);
    }
}
