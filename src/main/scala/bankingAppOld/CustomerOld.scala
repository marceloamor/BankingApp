package bankingAppOld

import scala.collection.mutable
import scala.collection.mutable.{HashMap, ListBuffer}
import scala.io.StdIn.{readInt, readLine}
import scala.util
import scala.util.Random


class CustomerOld(fName: String, lName: String, pCode: String) extends BankOld{

  val firstName: String = fName
  val lastName: String = lName
  val postCode: String = pCode
  val sortCode: Int = Random.between(100000,999999)
  //var listOfAccount: Array[Account] = new Array[Account](2)
  var mapOfAccounts = new mutable.HashMap[Int, List[Int]].withDefault(Nil)

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
    println("What kind of account would you like to open? \n1- Checkings \n2- Savings")
    var option: Int = readInt
    var newAccount = new AccountOld(userIndex)
    var accNum = newAccount.accountNumber

    if (option == 1){
      //mapOfAccounts(userIndex) ::= newAccount
    }
  }

  def showAccounts(): Unit = {

    for (a <- mapOfAccounts){
      println()
    }
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
