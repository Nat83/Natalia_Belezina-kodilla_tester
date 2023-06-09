package wallet;

public class Cashier {
    private final CashSlot cashSlot;
    private String message;

    private String errorMessage;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, int amount) {
        if( (wallet.getBalance() >= amount && amount > 0)){
        wallet.debit(amount);
        cashSlot.dispense(amount);
        } else if (wallet.getBalance() < 0){
            this.errorMessage = "Sorry I can not withdraw, there is a debit on your account";
        }
        else this.errorMessage = "Sorry you do not have enough funds on your account";
    }

    public String getMessage(String message) {
        return message;
    }

    public String getErrorMessage () {
        return this.errorMessage;
    }

}
