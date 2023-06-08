package homework;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static homework.wordpicker.WordPicker.returnCorrectWord;


public class WordPickerSteps {

    private int chosenNumber;
    private String word;

    @Given("I choose number {int}")
    public void i_choose_number(Integer chosenNumber) {
        this.chosenNumber = chosenNumber;
    }
    @When("Chosen number is divisible by {int}")
    public void chosen_number_is_divisible_by(Integer int1) {
        this.word = returnCorrectWord(chosenNumber);
    }
    @Then("Program should display word {string}")
    public void program_should_display_word(String word) {
        this.word =word;
    }
    @When("Chosen number is divisible by {int} and {int}")
    public void chosen_number_is_divisible_by_and(Integer int1, Integer int2) {
        this.word = returnCorrectWord(chosenNumber);
    }

    @When("Chosen number is not divisible by {int} or {int} or both those numbers")
    public void chosen_number_is_not_divisible_by_or_or_both_those_numbers(Integer int1, Integer int2) {
        this.word = returnCorrectWord(chosenNumber);
    }

}
