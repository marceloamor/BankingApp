import bankingApp.Customer

import scala.io.StdIn.{readInt, readLine}

object BankingApp extends {
  def main(args: Array[String]): Unit = {
    var newBank = new Bank
    newBank.start()

  }
}

class Bank {

  var Admin = new Customer("Admin", "123", 0)
  var listOfCustomers: Set[Customer] = Set()
  listOfCustomers += Admin

  var marcelo = new Customer("marcelo", "123", 1);var aycan = new Customer("aycan", "123", 2);var thomas = new Customer("thomas", "123", 3);var sam = new Customer("sam", "456", 4)
  var jinesh = new Customer("jinesh", "456", 5);var sujatha = new Customer("sujatha", "456", 6);var marie = new Customer("marie", "789", 7)
  listOfCustomers += marcelo; listOfCustomers += aycan;listOfCustomers += thomas;listOfCustomers += sam;listOfCustomers += jinesh;listOfCustomers += sujatha;listOfCustomers += marie

  def start(): Unit = {
    var option = 0
    println("~~~Welcome to the Royal Wiley Bank!~~~")
    while (option != 10) {
      println("What would you like to do?\n" +
        "1- Create a new customer\n" +
        "2- Log in as existing customer\n" +
        "3- Log in as Admin\n" +
        "Enter option: ")
      option = readInt()
      option match {
        case 1 => createCustomer() //create a customer
        case 2 => logIn()
        case 3 => adminLogin()
        case _ => println("Option Invalid")
        case 10 => println("Thank you for banking with us!"); System.exit(0)
      }
    }
  }

  def createCustomer(): Unit = {
    println("What is your first name?")
    val firstName = readLine.capitalize
    println("What is your last name?")
    val lastName = readLine.capitalize
    val fullName = firstName + " " + lastName
    println("What is your postcode? No spaces")
    val postCode = readLine.toUpperCase()
    val ID = listOfCustomers.size

    val newCustomer = new Customer(fullName,postCode,ID)
    listOfCustomers += newCustomer

    println("Customer successfully created with the following details:")
    newCustomer.showDetails()
    println("Please write them down. You will need them to log in\n----------------------------------")
  }

  def logIn(): Unit = {
    println("What is your ID? ")
    var customerID = readInt()
    println("What is your post code? ")
    var postCode = readLine()
    val uniqueID = postCode+customerID.toString
    for (customer <- listOfCustomers){
      if(customer.getUniqueID() == "1230"){
        println("Successful Admin Login!")
        adminStart()
      }else if(customer.getUniqueID() == uniqueID){
        println("Successful Login! ")
        customer.start()
      }
    }
    println("Invalid Login"); start()
  }

  //////////admin functions/////////////

  def adminLogin(): Unit = {
    println("What is the Admin ID? ")
    var adminID = readInt()
    println("What is the Admin postcode/password? ")
    var postCode = readLine()
    val uniqueID = postCode + adminID.toString
    if (uniqueID == "1230"){adminStart()}
    else{println("Invalid Admin Login");start()}
  }

  def adminStart(): Unit = {
    //admin start page
    var option = 0
    while (option != 10) {
      println("Which Admin function would you like to use?\n" +
        "1- See all customers\n" +
        "2- Find specific customer\n" +
        "3- Set interest rate\n" +
        "10- Log out\n" +
        "Enter option: ")
      option = readInt()
      option match {
        case 1 => seeAllCustomers()
        case 2 => findCustomerStart()
        case 3 => //Set interest rate
        case _ => println("Option Invalid")
        case 10 => start()
      }
    }
  }

  def seeAllCustomers(): Unit = for (customer <- listOfCustomers){customer.showDetails()}

  def findCustomerStart(): Unit = {
    var option = 0
    println("Find customer by: \n1- Full Name\n2- Post Code\n3- ID\n10- Go Back\nYour Choice: ")
    option = readInt()
    option match {
      case 1 => searchCustomerByID()
      case 2 => searchCustomerByPostcode()
      case 3 => searchCustomerByName()
      case _ => println("Option Invalid")
      case 10 => adminStart()
    }
  }

  def searchCustomerByPostcode(): Unit = {
    var counter = 0
    println("What is the Postcode you are searching in? ")
    var postcode = readLine()
    for (customer <- listOfCustomers){
      if (customer.postCode == postcode){
        customer.showDetails()
        counter += 1
      }
    }
    if (counter == 0){println("No customers found in that Postcode"); findCustomerStart()}
    else {println(counter + " customers found in that Postcode")}
  }

  def searchCustomerByName(): Unit = {
    println("What is the name of the customer you are searching for? ")
    var name = readLine()
    for (customer <- listOfCustomers) {
      if (customer.fullName == name) {
        customer.showDetails()
      }
    }
  }

  def searchCustomerByID(): Unit = {
    println("What is the ID of the customer you are searching for? ")
    var ID = readInt()
    for (customer <- listOfCustomers) {
      if (customer.ID == ID) {
        customer.showDetails()
      }
    }
  }

}



//maps and shit
//var listOfCustomers: Map[Int, Customer] = Map(0 -> Admin) //a baseline student exists, this can be Admin in the BankingApp
