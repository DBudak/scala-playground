/*
  Set as an immutable representation of
  a group of elements. Sets and lists have many features in common and similar syntax,
  with a fundamental difference: the items of a set are unique and have no order.
*/
case class Student(id: Int, name: String, topics: Set[String])

// ------------------------------------- OPERATIONS
Set(1, 2, 3)
Set(1, "scala")
Set()

Set() + 1 // Set(1) will create a new set
Set(1, 2) - 2 //  Set(1)
Set(1, 2) - 3 //  Set(1, 2) Removing non-existing returns same Set
Set() - 2 // Set() Removing from, empty returns same Set

// also has exists, filter, contains, size, maxBy
def existsById(students: Set[Student], id: Int): Boolean =
  students.exists(_.id == id)

def filterByTopic(students: Set[Student],
                  topic: String): Set[Student] =
  students.filter { student =>
    student.topics.contains(topic)
  }

def maxByTopics(students: Set[Student]): Student =
  students.maxBy { student =>
    student.topics.size
  }

// ------------------------------------- MAP FLATTEN FOR COMPREHENSION

Set(0, 2, 4).map(_ * 3) //  Set(0, 6, 12)
Set(Set(1), Set(2)).flatten // Set(1,2)

Set(Set(1), Set(2)).flatMap(_ * 3) // Set(3, 6)


def getTopicsForStudentIds(students: Set[Student],
                           ids: Set[Int]): Set[String] =
  for {
    student <- students
    id <- ids
    if student.id == id
    topic <- student.topics
  } yield topic

// ------------------------------------- UNION INTERSECTION DIFF

/*
  union—For an instance of Set[A], the method union takes another Set[A] as its
  parameter. It returns a new set that contains all the values from any of them. You
  can also use the operator ++ as an alias for the method union
*/
// also has syntax def ++(other: Set[A]): Set[A]
Set(1, 2, 3).union(Set(1, 4)) //  Set(1, 2, 3, 4)

/*
  intersect—For an instance of Set[A], the method intersect takes another Set[A]
  as its parameter. It returns a new set with only the values they both contain. It
  also has an alias: the method &.
*/
Set(1, 2, 3).intersect(Set(1, 4)) // Set(1)

/*
  diff—For an instance of Set[A], the function diff takes Set[A] as its parameter. It
  returns a new set containing all the elements in the original set but not in the
  given one. You can also use the operator -- as its alias
 */
// also has syntax def --(other: Set[A]): Set[A]
Set(1, 2, 3).diff(Set(1, 4)) // Set(2, 3)