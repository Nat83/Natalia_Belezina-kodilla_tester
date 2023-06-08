package seasonchecker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seasonchecker.SeasonChecker.checkIfSummer;

public class IsItSummerSteps {
    private MonthDay today;
    private String answer;
    @Given("today is last day of December")
    public void today_is_last_day_of_december() {
        this.today = MonthDay.of(12, 31);
    }
    @Given("today is first day of August")
    public void today_is_first_day_of_august() {
        this.today = MonthDay.of(8, 1);
    }
    @Given("today is 10th day of February")
    public void today_is_10th_day_of_february() {
        this.today = MonthDay.of(2, 10);
    }
    @Given("today is 20th day of June")
    public void today_is_20th_day_of_june() {
        this.today = MonthDay.of(6, 20);
    }

    @When("I ask whether it's Summer")
    public void i_ask_whether_it_s_summer() {
        this.answer = checkIfSummer(this.today);
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        assertEquals(string, this.answer);
    }
}
