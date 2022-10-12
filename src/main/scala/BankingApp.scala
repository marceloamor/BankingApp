


// Scala program for Banking System
import bankingApp.{Account, Bank}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object BankingApp {
  def main(args: Array[String]): Unit = {
    var bank = new Bank
    var option: String = ""
    println("Hello! Welcome to the Royal Wiley Bank!")
    start()

    def start(): Unit = {
      while (option != "10") {
        println("What would you like to do?\n" +
          "1- Create customer\n" +
          "2- Log in\n" +
          "3- Print customers\n" +
          "Enter option: ")
        var option = readInt()
        option match {
          case 1 => bank.createCustomer() //create a customer
          case 2 => {
            logInPage()
          }
          case 3 => bank.getCustomers()
          case 10 => //exit
        }
      }
    }
    //if (bank.logIn) userPage()

    def logInPage(): Unit = {
      println("What is your post code?")
      val postCode = readLine
      if (bank.logIn(postCode)){
        var userIndex = bank.listOfPostCodes.indexOf(postCode)
        userPage(userIndex)
      }else{
        println("Incorrect Login")
      }
    }

    def userPage(userIndex: Int): Unit = {
      var user = bank.listOfCustomer(userIndex)
      while (option != "10") {
        println("YOU MADE IT HERE\n"+
                "your sortcode is: " + user.sortCode + user.getPostCode())
        var option = readInt()



        /*option match {
          case 1 => bank.createCustomer() //create a customer
          case 2 => if (!bank.logIn) {}
          case 3 => bank.getCustomers()
          case 10 => //exit
        }*/
      }
    }
  }
}



/*
var acc1 = new Account("Marcelo", "Amorelli")

var option: String = ""
println("Hello! Welcome to the Royal Wiley Bank!")
while (option != "Q") {
  println("What would you like to do?\n" +
    "1- See Details\n" +
    "2- Check Balance\n" +
    "3- Deposit Money\n" +
    "4- Withdraw Money\n" +
    "5- Create Account\n" +
    "6- See Accounts\n" +
    "Q- Exit\n" +
    "Enter Option: ")
  var option = readLine()
  if (option == "1") {
    acc1.getDetails()
  } else if (option == "2") {
    acc1.checkBalance()
  } else if (option == "3") {
    acc1.depositMoney()
  } else if (option == "4") {
    acc1.withdrawMoney()
  } else if (option == "5") {
    bank1.createCustomer
  } else if (option == "6") {
    bank1.getCustomers
*/
