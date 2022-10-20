import org.scalatest.funsuite.AnyFunSuite
import bankingApp._


class accountTest extends AnyFunSuite {

  test("test checkings account creation") {
    val newCheckings = new checkingsAccount(1)

    assert(newCheckings.accID === 1)
    assert(newCheckings.balance === 0)
  }

  test("test savings account creation") {
    val newSavings = new savingsAccount(1)

    assert(newSavings.accID === 1)
    assert(newSavings.balance === 0)
  }


}
