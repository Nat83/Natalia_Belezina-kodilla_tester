package wallet;

public class Cashier {
    private final CashSlot cashSlot;
    private String message;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }
    public void withdraw(Wallet wallet, int amount){
        cashSlot.dispense(amount);
    }

    public String getMessage(String message) {
        return message;
    }
}
