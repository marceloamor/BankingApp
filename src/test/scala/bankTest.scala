import org.scalatest.funsuite.AnyFunSuite
import deprecatedBank.{BankOld, CustomerOld}

import scala.collection.mutable.ListBuffer


//The test cases in the bankTest, customerTest, and accountTest files are testing
//the creation of classes. The app is highly interactive and therefore requires constant
//user input, making unit testing difficult for all functions. Those that are possible
//are done so in these files.

class bankTest extends AnyFunSuite {

  test("ensure class Bank is created smoothly") {
    var newBank = new Bank
    assert(newBank.listOfCustomers.isEmpty === false)
  }

  test("test admin functionality") {
    var newBank = new Bank
    assert(newBank.Admin.postCode === "12345678")
    assert(newBank.Admin.fullName === "Admin")
    assert(newBank.Admin.listOfAccounts.isEmpty === true)
    assert(newBank.Admin.getUniqueID() === "123456780")

  }




  test("(Deprecated) ensure  class Bank is created smoothly") {
    var newBank = new BankOld
    assert(newBank.listOfCustomer === ListBuffer())
    assert(newBank.listOfUniqueIDs === ListBuffer())
  }

  test("(Deprecated) check create customers and adding to list works") {
    val newBank = new BankOld
    val firstName = "Marcelo"
    val lastName = "Amorelli"
    val postCode = "123"
    val newCustomer = new CustomerOld(firstName, lastName, postCode)
    val uniqueID = postCode + newCustomer.sortCode

    newBank.listOfCustomer += newCustomer
    newBank.listOfUniqueIDs += uniqueID

    assert(newBank.listOfCustomer.head.firstName === "Marcelo")
    assert(newBank.listOfUniqueIDs.head.isBlank === false)
  }

  test("(Deprecated) check login functionality works with false user") {
    val newBank = new BankOld
    assert(newBank.logIn("123") === false)
  }

  test("(Deprecated) check login functionality works with real user") {
    val newBank = new BankOld
    val firstName = "Marcelo"
    val lastName = "Amorelli"
    val postCode = "123"
    val newCustomer = new CustomerOld(firstName, lastName, postCode)
    val uniqueID = postCode + newCustomer.sortCode
    newBank.listOfCustomer += newCustomer
    newBank.listOfUniqueIDs += uniqueID

    assert(newBank.logIn("123"+newCustomer.sortCode) === true)
  }


}
