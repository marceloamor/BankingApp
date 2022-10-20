package bankingApp

//checking account with ID correlating with its index in a customer's listOfAccounts
class checkingsAccount(ID:Int) extends Account {
  override val accID: Int = ID
}
