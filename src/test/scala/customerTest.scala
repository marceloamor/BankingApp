import org.scalatest.funsuite.AnyFunSuite
import bankingApp.Customer


class customerTest extends AnyFunSuite {

  test("ensure new customer class is created and uniqueID functionality works") {
    val newCustomer = new Customer("Marcelo Amorelli", "SE173PQ", 1)

    assert(newCustomer.fullName === "Marcelo Amorelli")
    assert(newCustomer.postCode === "SE173PQ")
    assert(newCustomer.ID === 1)
    assert(newCustomer.getUniqueID() === "SE173PQ1")
    assert(newCustomer.listOfAccounts.isEmpty === true)
  }

}
