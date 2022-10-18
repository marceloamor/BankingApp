


// Scala program for Banking System
import bankingApp.{Account, Bank}

import scala.collection.mutable.{ListBuffer, Map}
import scala.io.StdIn.{readInt, readLine}
import scala.util.control.Breaks.break

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
          case 2 => logInPage()
          case 3 => bank.getCustomers()
          case 10 => break
        }
      }
    }
    //if (bank.logIn) userPage()

    def logInPage(): Unit = {
      println("What is your post code?")
      val postCode = readLine
      println("What is your sort code? ")
      val sortCode = readLine
      val uniqueID = postCode+sortCode
      if (bank.logIn(uniqueID)){
        println("Log-in Successful")
        var userIndex = bank.listOfUniqueIDs.indexOf(uniqueID)
        userPage(userIndex)
      }else{
        println("Incorrect Login")
      }
    }

    def userPage(userIndex: Int): Unit = {
      val user = bank.listOfCustomer(userIndex)
      while (option != "10") {
        println("Hello " + user.getFullName + "! What would you like to do?\n" +
          "1- See details\n" +
          "2- Create account\n" +
          "3- See accounts\n" +
          "4- Get support\n" +
          "10- Log Out\n" +
          "Enter option: ")
        var option = readInt()
        option match {
          case 1 => user.getDetails()
          case 2 => user.createAccount(userIndex)
          case 3 => user.showAccounts()
          case 4 => println("All staff busy at the moment, try again later")
          case 10 => start()

        }
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
