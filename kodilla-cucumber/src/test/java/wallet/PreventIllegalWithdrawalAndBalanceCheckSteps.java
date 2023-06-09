package wallet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class PreventIllegalWithdrawalAndBalanceCheckSteps {
    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    private final Cashier cashier = new Cashier(cashSlot);
    @Given("there is ${int} in my wallet")
    public void there_is_$_in_my_wallet(Integer balance) {
        wallet.deposit(balance);
        System.out.println(wallet.getBalance());
    }
    @When("I withdraw ${int}")
    public void i_withdraw_$(Integer amount) {
        cashier.withdraw(wallet, amount);
    }
    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        Assertions.assertEquals(0, cashSlot.getContents());
    }
    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_that_i_don_t_have_enough_money_in_my_wallet() {
        Assertions.assertEquals("Sorry you do not have enough funds on your account",
                cashier.getErrorMessage());
    }
    @Then("I should be told that money can not be withdrawn and there is a debit on the account")
    public void i_should_be_told_that_money_can_not_be_withdrawn_and_there_is_a_debit_on_the_account() {
        Assertions.assertEquals("Sorry I can not withdraw, there is a debit on your account",
                cashier.getErrorMessage());
    }
    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        System.out.println(wallet.getBalance());
    }
    @Then("I should see that the balance is ${int}")
    public void i_should_see_that_the_balance_is_$(Integer amount) {
        Assertions.assertEquals(amount, wallet.getBalance());
    }
    @Then("I get message {string}")
    public void i_get_message(String message) {
        Assertions.assertEquals(message, wallet.getBalanceMessage());
    }
}
