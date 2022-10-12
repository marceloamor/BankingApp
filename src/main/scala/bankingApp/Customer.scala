package bankingApp

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random


class Customer(firstName: String, lastName: String, postCode: String) extends Bank{

  val sortCode: Int = Random.between(100000,999999)
  //var listOfAccount: Array[Account] = new Array[Account](2)
  var listOfAccounts = new ListBuffer[Account]()

  def getDetails(): Unit = {
    println("First name: " + firstName + "\nLast name: " + lastName +
            "\nSort Code: " +sortCode + "\nPost Code: " + postCode)
  }

  def getFullName(): Unit = {
    firstName
  }
  def getPostCode(): String = {
    postCode
  }

  def createAccount(userIndex: Int): Unit = {
    var newAccount = new Account(userIndex)
    mapOfAccounts(userIndex) = newAccount
  }



  /*def createAccount: Unit = {
    println("First Name: ")
    var firstName = readLine()
    print("Last name: ")
    var lastName = readLine()
    var newAccount = new Account(firstName, lastName)
    listOfAccount(0) = newAccount
    println("new account created for " + firstName + " " + lastName)
  }*/



}
