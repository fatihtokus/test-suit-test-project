package tcon;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class MyStepdefs {
    @When("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        Assertions.assertThat("a").isEqualTo("a");
    }
}
