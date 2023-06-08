package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class WalletSteps {

    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    private final Cashier cashier = new Cashier(cashSlot);
    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_$_in_my_wallet(Integer int1) {

        wallet.deposit(int1);
        Assertions.assertEquals(200, wallet.getBalance(),"Incorrect wallet balance");
    }
    @When("I request ${int}")
    public void i_request_$(Integer int1) {
        cashier.withdraw(wallet, 30);
    }
    @When("I request amount in decimal format ${double}")
    public void i_request_amount_in_decimal_format_$(Double double1) {
        System.out.println("Only integers can be used for the cash withdrawal");
    }
    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(Integer int1) {
        Assertions.assertEquals(30, cashSlot.getContents());
    }

    @Then("Cashier will reply {string}")
    public void cashier_will_reply(String message) {
        Assertions.assertEquals(message, cashier.getMessage(message));
    }
}
