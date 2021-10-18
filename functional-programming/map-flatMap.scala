/*

  In Scala, you refer to the operation of applying a function to the content of an optional
  value as map. The function map is a higher order function defined on Option that takes a
    function f as its parameter:
   If the optional value is present, it will apply the function f to it and return it
  wrapped as optional value.
   If the optional instance is None, it will return it without applying any function.

 */

def map[B](f: A => B): Option[B] =
  this match {
    case Some(a) => Some(f(a))
    case None => None
  }

case class Car(model: String,
               owner: Option[Person],
               registrationPlate: Option[String])

case class Person(name: String,
                  age: Int,
                  drivingLicense: Option[String])

def ownerName(car: Car): Option[String] =
  car.owner.map(p => p.name)

def ownerDrivingLicense(car: Car): Option[String] =
  car.owner.flatMap(_.drivingLicense)


// Tasks

def superFlatten(
                  opt: Option[Option[Option[String]]]
                ): Option[String] = opt.flatten.flatten