/*
  The expressions optCar, car.owner, and person.drivingLicense are all producing an
  optional value: they have type Option[Car], Option[Person], Option[String], respectively.
  The values car, person, and drivingLicense are their corresponding extracted values: type
  Car, Person, and String. You also encountered a new keyword, yield, which returns a value
  you can compute using the extracted values wrapped into an Option. In this case, it returns
  the value of drivingLicense as an optional value. As soon as the for-comprehension
  finds an absent optional value (e.g., car.owner is None), it evaluates the entire expression as None.
*/

/*
  You can modify the yield values in for-comprehension (e.g., drivingLicense.toUppercase)
  and add conditions to stop the combination of values by adding the keyword if followed
  by a Boolean expression (e.g., if person.name == ownerName)
*/

// tldr: evaluates multiple options and if any is None then all are None
// use this if you want to check if all options are not None then extract

// also can add boolean expressions, if it is false all evaluates to None

case class Car(model: String,
               owner: Option[Person],
               registrationPlate: Option[String])

case class Person(name: String,
                  age: Int,
                  drivingLicense: Option[String])

def ownerDrivingLicense(
                         optCar: Option[Car],
                         ownerName: String
                       ): Option[String] =
  for {
    car <- optCar
    person <- car.owner
    if person.name == ownerName
    rn <- car.registrationPlate
    drivingLicense <- person.drivingLicense
  } yield drivingLicense


val tom = Person("Tom", 20, Option("21"))
val tomsCar = Car("Honda", Option(tom), Option("AVS"))
val unregisteredCar = Car("Toyota", Option(tom), None)
val unownedCar = Car("Jeep", None, None)
val noDrivingLicenseBob = Person("Bob", 16, None)
val bobsCar = Car("Honda", Option(noDrivingLicenseBob), Option("AVS"))

println(ownerDrivingLicense(Option(tomsCar), "Tom")) // Option("21")
println(ownerDrivingLicense(Option(unregisteredCar), "Tom")) // None
println(ownerDrivingLicense(Option(unownedCar), "Tom")) // None
println(ownerDrivingLicense(Option(bobsCar), "Bob")) // None

println(ownerDrivingLicense(Option(tomsCar), "Bob")) // None


// TASK
/*
  Quick Check 24.3 Implement a function called carWithLicensedOwner that takes
  and returns an optional car instance if its owner has a driving license.
  def carWithLicensedOwner(optCar: Option[Car]): Option[Car]
*/
def carWithLicensedOwner(optCar: Option[Car]): Option[Car] =
for {
  car <- optCar
  owner <- car.owner
  if owner.drivingLicense.isDefined
} yield car

println(carWithLicensedOwner(Option(tomsCar)))
println(carWithLicensedOwner(Option(bobsCar)))