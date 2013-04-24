package com.octo.spike;

import junit.framework.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class LoginScreenStepdefs {

    private LoginServer loginServer = LoginServer.getInstance();

        @Given("^an account list:$")
        public void an_account_list(List<Account> accounts) {
            for(Account account : accounts) {
                loginServer.createUser(account.login,account.password);
            }
        }

        @When("^I connect with login \"([^\"]*)\" and secure password \"([^\"]*)\"$")
        public void i_connect_With_login_and_secure_password(String login,String password) {
            loginServer.connect(login,password);
        }

        @Then("^It will display \"([^\"]*)\"$")
        public void it_will_display(String aStringToBeDisplayed) {
            Assert.assertEquals(aStringToBeDisplayed, loginServer.messageLogin());
        }

        public class Account {
            String login;
            String password;
        }
}
