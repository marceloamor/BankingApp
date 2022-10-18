package bankingApp

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

class Bank {

  var listOfCustomer = new ListBuffer[Customer]()
  var listOfUniqueIDs = new ListBuffer[String]()


  def createCustomer(): Unit = {
    println("What is your first name?")
    val firstName = readLine
    println("What is your last name?")
    val lastName = readLine
    println("What is your postcode? No spaces")
    val postCode = readLine
    val newCustomer = new Customer(firstName, lastName, postCode)
    val uniqueID = postCode + newCustomer.sortCode
    println("Below are your details. Please write them down\n" + newCustomer.getDetails)
    listOfCustomer += newCustomer
    listOfUniqueIDs += uniqueID
    //println(listOfCustomer)
  }

  def getCustomers(): Unit = {
    for (a<- listOfCustomer){
      println(a.getDetails())
    }
  }

  def logIn(uniqueID: String): Boolean = {
    var validUser: Boolean = false
    for (a <- listOfUniqueIDs){
      if (a == uniqueID){
        validUser = true
      }
    }
    if (validUser){
      true
    }else{
      false
    }
  }

}

