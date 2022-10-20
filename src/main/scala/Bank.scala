import bankingApp.Customer
import org.joda.time.DateTime


import scala.io.StdIn.{readInt, readLine}

object BankingApp {
  def main(args: Array[String]): Unit = {
    var newBank = new Bank //create instance of Bank upon startup and present the start menu
    newBank.start()
  }
}

class Bank {

  //create an Admin customer, a registry of customers, and begin populating it
  var Admin = new Customer("Admin", "12345678", 0)
  var listOfCustomers: Set[Customer] = Set()
  listOfCustomers += Admin

  //the Bank's frontend start menu allowing for interactivity
  def start(): Unit = {
    var option = 0
    println("~~~Welcome to the Royal Wiley Bank!~~~")
    while (option != 10) {
      println("What would you like to do?\n" +
        "1- Create a new customer\n" +
        "2- Log in as existing customer\n" +
        "3- Log in as Admin\n" +
        "Enter option: ")
      try {
        option = readInt()
        option match {
          case 1 => createCustomer() //create a customer
          case 2 => logIn()
          case 3 => adminLogin()
          case 10 => println("Thank you for banking with us!"); System.exit(0)
          case _ => println("Option Invalid")
        }
      }catch {case e: NumberFormatException => println("Invalid Option. Try again")}
    }
  }

  //allows user to create a new customer in the bank
  def createCustomer(): Unit = {
    println("What is your first name?")
    val firstName = readLine.capitalize
    println("What is your last name?")
    val lastName = readLine.capitalize
    val fullName = firstName + " " + lastName
    println("What is your postcode? No spaces")
    val postCode = readLine.toUpperCase()
    val ID = listOfCustomers.size  //gives users an ID that is their index in the Set()

    val newCustomer = new Customer(fullName,postCode,ID)
    listOfCustomers += newCustomer

    println("Customer successfully created with the following details:")
    newCustomer.showDetails()
    println("Please write them down. You will need them to log in\n----------------------------------")
  }

  //login function. Uses a customers ID and postcode to create a unique ID needed for
  def logIn(): Unit = {
    var isLoggedIn:Boolean = false
    println("What is your ID? ")
    val customerID = readInt()
    println("What is your post code? ")
    var postCode = readLine().toUpperCase()
    val uniqueID = postCode+customerID.toString //creates uniqueID from user input

    println("Please wait while we log you in")
    pauseForEffect(3) //Thread.sleep function for show

    for (customer <- listOfCustomers){
      if(customer.getUniqueID() == "123456780"){ //lets admin log in from normal login too
        println("Successful Admin Login!")
        isLoggedIn = true
        adminStart()
      }else if(customer.getUniqueID() == uniqueID){ //checks if a customer's unique ID exists and logs them in
        createLoginHistory(customer)
        println("Successful Login! ")
        isLoggedIn = true
        customer.start()
      }
    }
    if (!isLoggedIn) println("Invalid Login")
  }

  //////////admin functions/////////////

  def adminLogin(): Unit = {
    println("What is the Admin ID? ")
    var adminID = readInt()
    println("What is the Admin postcode/password? ")
    var adminPostCode = readLine()
    val uniqueID = adminPostCode + adminID.toString
    if (uniqueID == "123456780"){println("Successful Admin Login");adminStart()}
    else{println("Invalid Admin Login")}
  }

  //admin start page
  def adminStart(): Unit = {
    //admin start page
    var option = 0
    while (option != 10) {
      println("Which Admin function would you like to use?\n" +
        "1- See all customers\n" +
        "2- Find specific customer\n" +
        "3- See Login Log\n" +
        "10- Log out\n" +
        "Enter option: ")
      option = readInt()
      option match {
        case 1 => seeAllCustomers()
        case 2 => findCustomerStart()
        case 3 => seeLog()
        case 10 => option = 10
        case _ => println("Option Invalid")
      }
    }
  }
  //returns all customers for Admin
  def seeAllCustomers(): Unit = for (customer <- listOfCustomers){customer.showDetails()}

  //provides functionality to search for a specific customer by several methods
  def findCustomerStart(): Unit = {
    var option = 0
    println("Find customer by: \n1- Full Name\n2- Post Code\n3- ID\n10- Go Back\nYour Choice: ")
    option = readInt()
    option match {
      case 1 => searchCustomerByID()
      case 2 => searchCustomerByPostcode()
      case 3 => searchCustomerByName()
      case 10 => option = 10
      case _ => println("Option Invalid")
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
    if (counter == 0)println("No customers found in that Postcode")
    else println(counter + " customers found in that Postcode")
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

  //Admin function to read the .txt file that holds the login history
  def seeLog(): Unit = {
    val source = scala.io.Source.fromFile("C:\\Users\\44799\\IdeaProjects\\BankingApp1\\src\\main\\scala\\bankingApp\\loginHistory.txt")
    val lines = try source.mkString finally source.close()
    print(lines)
  }

  //cheeky function that creates dramatic effect
  def pauseForEffect(pauseTime: Int): Unit = {
    for (secs <- 1 to pauseTime){
      Thread.sleep(1000)
      println(".")
    }
  }

  //maintains a log of users that have logged in and datestamps for it
  def createLoginHistory(customer: Customer): Unit = {
    var dt = new DateTime()
    reflect.io.File("C:\\Users\\44799\\IdeaProjects\\BankingApp1\\src\\main\\scala\\bankingApp\\loginHistory.txt")
      .appendAll(s"-------------------------------------------------------------------------\n" +
        s"${customer.fullName} logged in at $dt. \nCustomer ID: ${customer.ID} \nPostcode: ${customer.postCode}\n")
  }
}
