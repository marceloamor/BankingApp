package bankingApp

abstract class Account {

  val accID: Int
  var balance: Double = 0.00


  //attributes: ID,Balance,Loans?,CardNum/Year/mo/cvv

  //start()
  //logOut

  def getAccountDetails(): Unit = {
    println(s"Welcome to your ${getClass.getSimpleName} account. Your details are:\nAccount ID: $accID and your balance is: $balance")
  }

  //def depositFunds

  //def withdrawFunds

  //def sendFunds

  //def newCard/yr/mo/cvv
  //def requestLoan()??



}
