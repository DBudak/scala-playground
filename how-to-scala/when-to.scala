/*
    DATA:
        Class               |   To represent data with complex computations attached to it
        Case Class          |   To represent immutable data dependent on its constructor arguments without stateful computations on the inside   
        Abstract Class      |   To represent "interface" funnel. Single inheritance interface.
        Trait               |   To represent and enforce common behavior between classes and for multi-inheritance
        Sealed Trait        |   For fixed number of subclasses
        ADT                 |   To represent and pattern match though CASES OF something
        Typeclass           |   To write methods that auto-invoke based on type.To allow consumers to "extend the trait" for the class they can't modify           
        Companion Object    |   To add static methods to classes. Static methods act on a class rather than specific instance of it.
        Singleton Objects   |   For utilities/configs
        Case Object         |   To create exactly ONE immutable instance of data for all code. Used in SUM ADT.
        Annotations         |   To Add meta information for compiler

    DEFAULT COLLECTIONS:
        List                |   Immutable linear linked list
        ListBuffer          |   Mutable linear linked list
        Vector              |   Indexed immutable
        ArrayBuffer         |   Indexed mutable
    VARIATIONS OF LIST:
        Set                 |   List with unique values
        Tuple               |   List with different types
        Map                 |   Unique unordered keys referencing values

    CONTAINERS:
        Option              |   To handle potential of null
        Try                 |   To handle potential of exception
        Either              |   To handle potential of exception and provide an error

    OPERATIONS:
        Pattern Matching    |   To work through cases of data. Advanced switch/case
        For Comprehension   |   Reduce operation with implicit None checks
        ::                  |   case first :: rest => ???. Extractor on the RIGHT operand.
        <:                  |   class Foo[T <: Type]. T must extend Type.

    METHODS:
        Implicit Parameter  |   (implicit n: Int) To reduce the amount of code when passing some parameter needed in a lot of methods
        By-name Parameter   |   (n: => Int) To lazy evaluate a parameter
        Optional Parameter  |   (n: Int = 1) Providing default value makes it optional
*/
