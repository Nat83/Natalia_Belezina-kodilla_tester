package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class WalletSteps {

    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_$_in_my_wallet(Integer int1) {

        wallet.deposit(200);
        Assertions.assertEquals(200, wallet.getBalance(),"Incorrect wallet balance");
    }
    @When("I request ${int}")
    public void i_request_$(Integer int1) {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, 30);
    }
    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(Integer int1) {
        Assertions.assertEquals(30, cashSlot.getContents());
    }
}
