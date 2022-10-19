package bankingApp

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}


class Customer(fName:String, pCode:String, newID: Int) {

  var fullName: String = fName
  var postCode: String = pCode
  final val ID = newID
  private var uniqueID = postCode.toString + ID.toString

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
        case 5 => //access an account)
        case 6 => //get support
        case _ => println("Option Invalid")
        case 10 => println("Logging out")
      }
    }
  }

  def getUniqueID(): String = uniqueID

  def showDetails(): Unit = {
    println("____________________________________________")
    println("|  Full Name:  " + fullName + "\n|  Post Code:  " + postCode + "\n|  ID Number:  " + ID)
    println("|____________________________________________")
  }

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

  def updateName(): Unit = {
    println("What would you like to change your name to? First and Last:")
    var newName = readLine()
    fullName = newName.capitalize
    println("Name successfully changed, thank you " +fullName )
  }
  def updatePostcode(): Unit = {
    println("What would you like to change your postcode to?")
    var newPostcode = readLine()
    postCode = newPostcode.toUpperCase
    println("Postcode successfully changed, thank you " + postCode )

  }


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

  def createCheckingAccount: Unit = {
    val checkingsAccount = new checkingsAccount(listOfAccounts.size+1)
    listOfAccounts += checkingsAccount

  }
  def createSavingsAccount: Unit = {

    val savingsAccount = new savingsAccount(listOfAccounts.size)
    listOfAccounts += savingsAccount
  }

  def seeAccounts(): Unit = {
    for (acc <- listOfAccounts){
      acc.getAccountDetails()
    }
  }

  //def accessAccount()

  //send and receive money????? eh i think this goes in accounts instead of being in Customer

  var newAccount = new savingsAccount(1)
  newAccount.getClass

}
