package wallet;

public class Wallet {
    private int balance = 0;
    private String balanceMessage;

    public Wallet() {
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int money) {
        this.balance -= money;
    }

    public String getBalanceMessage(){
        if(getBalance()<0 && getBalance()>-300){
            balanceMessage = "Warning, after reaching $300 debit you will be charged $1000 fee";
        }else if (getBalance()<=-300){
            balanceMessage = "Warning, You have reached $300 debit an your account will be charged with $1000 fee.";
        }else if (getBalance()>=50000){
            balanceMessage = "Your balance allows you to upgrade to our premium account? Are you interested?";
        }else{
            balanceMessage = "Here is your balance. Visit our website www.funnyBank.com if you have any questions.";
        }
        return balanceMessage;
    }
}
