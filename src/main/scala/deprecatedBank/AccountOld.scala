package deprecatedBank

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readInt
import scala.io.StdIn.{readInt, readLine, readDouble}
import scala.util.Random

class AccountOld(userIndex: Int){

  var balance: Double = 1000
  val accountNumber: Int = Random.between(10000000,99999999)

  def checkBalance(): Unit = {
    println(s"Your current balance is: £$balance")
  }

  /*def getAccountDetails(): Unit = {
    println("Full Name: " + firstName + " " + lastName +"\n"+
            s"UserID: ${sortCode}\n" +
            s"Account Number: $accountNumber")
  }*/

  // withdraw money function
  def withdrawMoney(): Unit = {
    var validNumber: Boolean = false
    while (!validNumber){
      println("How much would you like to withdraw (denominations of 20)? ")
      var amount: Int = readInt().toInt
      if (amount > balance) {
        println("Balance Insufficient")
      } else if (amount < 0 || amount % 20 != 0) {
        println("Invalid Amount")
      } else {
        balance -= amount
        println("Amount withdrawn. New balance: " + balance)
        validNumber = true
      }
    }
  }
  def depositMoney(): Unit = {
    println("How much would you like to deposit? ")
    var amount: Double = readDouble()
    balance += amount
    println(s"$amount deposited. New balance: $balance")
  }

  //def transferMoney(): Unit = {}

}
