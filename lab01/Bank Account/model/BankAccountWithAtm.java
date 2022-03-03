package lab01.example.model;

public class BankAccountWithAtm implements BankAccount{

    private final AccountHolder holder;
    private double balance;
    private static final int FEE = 1;


    public BankAccountWithAtm(AccountHolder holder, double balance) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (checkUser(userID)){
            balance += (amount - FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)){
            this.balance -= (amount + FEE);
        }
    }

    private boolean checkUser(final int id){
        return this.holder.getId() == id;
    }

    private boolean isWithdrawAllowed(final double amount){
        return (this.getBalance() >= (amount + FEE));
    }
}
