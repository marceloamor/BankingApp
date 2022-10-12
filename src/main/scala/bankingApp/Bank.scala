package bankingApp

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

class Bank {

  var listOfCustomer = new ListBuffer[Customer]()
  var listOfPostCodes = new ListBuffer[String]()

  def createCustomer(): Unit = {
    println("What is your first name?")
    val firstName = readLine
    println("What is your last name?")
    val lastName = readLine
    println("What is your postcode? No spaces")
    val postCode = readLine
    var newCustomer = new Customer(firstName, lastName, postCode)
    //newCustomer.getDetails()
    listOfCustomer += newCustomer
    listOfPostCodes += postCode
    //println(listOfCustomer)
  }

  def getCustomers(): Unit = {
    for (a<- listOfCustomer){
      println(a.getDetails())
    }
  }

  def logIn(postCode: String): Boolean = {
    var validUser: Boolean = false
    for (a <- listOfPostCodes){
      if (a == postCode){
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

