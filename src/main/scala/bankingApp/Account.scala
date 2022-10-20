package bankingApp
import scala.io.StdIn.{readDouble, readFloat, readInt}


abstract class Account {  //abstract class representing possible account types

  val accID: Int
  var balance :Double = 0.0

  //The Account start menu with the options seen when an account is selected by customer
  def start(): Unit = {
    var option = 0
    while (option != 10) {
      println(s"Welcome to your ${getClass.getSimpleName.toString.capitalize} ")
      println("What would you like to do?\n" +
        "1- See my account details \n" +
        "2- Deposit funds\n" +
        "3- Withdraw funds\n" +
        "10- Go back\n" +
        "Enter option: ")
      option = readInt()
      option match {
        case 1 => getAccountDetails()
        case 2 => depositFunds()
        case 3 => withdrawFunds()
        case 10 =>
        case _ => println("Option Invalid")
      }
    }
  }  //logOut

  //returns the account details, used within an account and within customer class to see all accounts
  def getAccountDetails(): Unit = {
    println(s"Your details are:\nAccount ID: $accID with balance: $balance")
    println("--------------------------------------")
  }

  //simple deposit funds function using user input
  def depositFunds(): Unit = {
    println(f"Your current balance is $balance%1.2f. How much would you like to deposit? ")
    var deposit: Double = readDouble()
    balance += deposit
    println(f"Deposit Successful. Your balance is now $balance%1.2f")
  }

  //simple withdraw funds function, verifying sufficient funds are available
  def withdrawFunds(): Unit = {
    println(f"Your current balance is $balance%1.2f. How much would you like to withdraw? ")
    var withdrawal: Double = readDouble()
    if (withdrawal > balance)println("Insufficient Funds")
    else{
      balance -= withdrawal
      println(f"Withdrawal Successful. Your balance is now $balance%1.2f")
    }
  }
}
