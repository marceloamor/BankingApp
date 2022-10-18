import org.scalatest.funsuite.AnyFunSuite
import bankingApp.{Bank, Customer}

import scala.collection.mutable.ListBuffer

class bankTest extends AnyFunSuite {

  test("ensure class Bank is created smoothly") {
    var newBank = new Bank
    assert(newBank.listOfCustomer === ListBuffer())
    assert(newBank.listOfUniqueIDs === ListBuffer())
  }

  test("check create customers and adding to list works") {
    val newBank = new Bank
    val firstName = "Marcelo"
    val lastName = "Amorelli"
    val postCode = "123"
    val newCustomer = new Customer(firstName, lastName, postCode)
    val uniqueID = postCode + newCustomer.sortCode

    newBank.listOfCustomer += newCustomer
    newBank.listOfUniqueIDs += uniqueID

    assert(newBank.listOfCustomer.head.firstName === "Marcelo")
    assert(newBank.listOfUniqueIDs.head.isBlank === false)
  }

  test("check login functionality works with false user") {
    val newBank = new Bank
    assert(newBank.logIn("123") === false)
  }

  test("check login functionality works with real user") {
    val newBank = new Bank
    val firstName = "Marcelo"
    val lastName = "Amorelli"
    val postCode = "123"
    val newCustomer = new Customer(firstName, lastName, postCode)
    val uniqueID = postCode + newCustomer.sortCode
    newBank.listOfCustomer += newCustomer
    newBank.listOfUniqueIDs += uniqueID

    assert(newBank.logIn("123"+newCustomer.sortCode) === true)
  }


}