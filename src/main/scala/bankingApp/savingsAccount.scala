package bankingApp

//savings account with ID correlating with its index in a customer's listOfAccounts
class savingsAccount(ID:Int) extends Account {
  override val accID: Int = ID
}
