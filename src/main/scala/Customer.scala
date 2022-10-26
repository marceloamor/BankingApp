package bankingApp

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}
import scala.util.control.Breaks.break


class Customer(fName:String, pCode:String, newID: Int) {

  var fullName: String = fName
  var postCode: String = pCode
  final val ID = newID
  private var uniqueID = postCode + ID.toString

  var listOfAccounts: ListBuffer[Account] = ListBuffer() //could be a set, but for the assignment using different collections

  def start(): Unit = {
    var option = 0
    while (option != 10) {
      println("Hello " + fullName +". Thank you for joining us today.")
      println("What would you like to do?\n" +
        "1- See my customer details \n" +
        "2- Update my details\n" +
        "3- See my accounts\n" +
        "4- Create an account\n" +
        "5- Access an account\n" +
        "6- Customer Support\n" +
        "10- Log Out\n" +
        "Enter option: ")
      option = readInt()
      option match {
        case 1 => showDetails()
        case 2 => updateDetails()
        case 3 => seeAccounts()
        case 4 => createAccount()
        case 5 => accessAccount()
        case 6 => getSupport()
        case 10 => println("Logging out");Thread.sleep(1000);println(".");Thread.sleep(1000);println(".")
        case _ => println("Option Invalid")
      }
    }
  }

  def getUniqueID(): String = uniqueID

  //function returns a user's formatted details
  def showDetails(): Unit = {
    println("____________________________________________")
    println("|  Full Name:  " + fullName + "\n|  Post Code:  " + postCode + "\n|  ID Number:  " + ID)
    println("|____________________________________________")
  }

  //allows the user to update their name or postcode
  def updateDetails(): Unit = {
    var option = 0
    while (option != 10) {
      println("Which of your details would you like to update?\n" +
        "1- Name\n" +
        "2- Post Code\n" +
        "10- Go Back\n" +
        "Enter option: ")
      option = readInt()
      option match {
        case 1 => updateName()
        case 2 => updatePostcode()
        case _ => println("Option Invalid")
        case 10 => option = 10
      }
    }
  }

  //function called by updateDetails, deals with the name
  def updateName(): Unit = {
    println("What would you like to change your name to? First and Last:")
    var newName = readLine()
    fullName = newName.capitalize
    println("Name successfully changed, thank you " +fullName )
  }
  //function called by updateDetails, deals with the postcode
  def updatePostcode(): Unit = {
    println("What would you like to change your postcode to?")
    var newPostcode = readLine()
    postCode = newPostcode.toUpperCase
    println("Postcode successfully changed, thank you ")

  }

  //creates a new account of type checkings or savings with user input
  def createAccount(): Unit = {
    var option = 0
    println("What type of account would you like to open? \n1- Checking Account \n2- Savings Account\n10- Go Back\nYour Choice: ")
    option = readInt()
    option match {
      case 1 => createCheckingAccount
      case 2 => createSavingsAccount
      case _ => println("Option Invalid")
      case 10 => option = 10
    }
  }

  //creates a checking account, allocates an account ID,
  // adds it to a customers list of accounts, and allows for initial deposit
  def createCheckingAccount():Unit = {
    val checkingsAccount = new checkingsAccount(listOfAccounts.size+1)
    listOfAccounts += checkingsAccount
    checkingsAccount.depositFunds()

  }

  //creates a savings account, allocates an account ID,
  // adds it to a customers list of accounts, and allows for initial deposit
  def createSavingsAccount(): Unit = {
    val savingsAccount = new savingsAccount(listOfAccounts.size+1)
    listOfAccounts += savingsAccount
    savingsAccount.depositFunds()
  }

  //allows user to see all their current accounts and details, and tells them how many accounts they have
  def seeAccounts(): Unit = {
    println("----------------------------------------")
    if (listOfAccounts.isEmpty){println("You currently have 0 accounts with us.")}
    else {println(s"You currently have ${listOfAccounts.size} accounts with us")}
    for (acc <- listOfAccounts){
      acc.getAccountDetails()
    }
    println("----------------------------------------")
  }

  //function that gives the appearance of an existing customer service branch
  def getSupport(): Unit = {
    println("Please hold while we connect you to a customer service representative.")
    Thread.sleep(1000)
    println(".")
    Thread.sleep(1000)
    println(".")
    Thread.sleep(1000)
    println(".")
    Thread.sleep(1000)
    println("-----------------------------------------------------")
    println("All staff busy at the moment, please try again later")
    println("-----------------------------------------------------")

  }

  //allows the user to select a specific account and access its start menu
  def accessAccount(): Unit = {
    println("What is the ID of the account would you like to access?")
    val account = readInt()
    for (acc <- listOfAccounts){if (acc.accID == account) acc.start()}
  }

}
