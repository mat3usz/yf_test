package yf;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import yf.PageObjects.StockPage;


public class Registration {
    private StockPage stockPagePage = new StockPage();

    @Given("user is on F5 page")
    public void user_is_on_specified_page() {
        stockPagePage.assertUserIsOnCorrectPage();
    }

    @Then("highest closing price since 5 days is printed")
    public void warning_messages_are_displayed() throws Exception {
        Double maxClosingPrice = stockPagePage.getMaxClosingPrice(5);
        System.out.println("Highest price: " + maxClosingPrice);
        assert maxClosingPrice.equals(157.11); // temporal assertion as price changes
    }
}