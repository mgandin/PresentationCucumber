Feature: Login Screen

  So that I want to connect and view my hello login message
  As a new user
  I want to create a new Account with secure password


  Background : account list
    Given an account list:
      | login | password     |
      | jfh   | dictionn@ire |

  Scenario: secure password
    Given an account list:
      | login | password |
      | mga   | p@ssword |
    When I connect with login "mga" and secure password "p@ssword"
    Then It will display "Hello mga"

  Scenario Outline: secure password examples
    Given an account list:
      | login | password |
      | mga   | p@ssword |
    When I connect with login <login> and secure password <pwd>
    Then It will display <message>

  Examples:
    | login | pwd            | message     |
    | "mga" | "p@ssword"     | "Hello mga" |
    | "jfh" | "dictionn@ire" | "Hello jfh" |