// x is private
// y is public
// bar  gets computed once the class is instantiated
// bar is public 
// _bar is private
// msg is optional (param becomes optional when there is a default)


class Foo(x: Int, val y: String) {
    val bar: Int = 1
    private val _bar: Int = 2
    def baz(msg:String = "Hello") = {println(msg)}
}

// =============== ADT

// Instances of entitity
// Useful to pattern match
// Core brick to build Scala apps

trait Account

case class BankAccount() extends Account
case class AchAccount() extends Account
