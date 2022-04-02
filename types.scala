// Scala infers types
// Unit is void
// Scala uses Java types with additional features on them
// Scala can't infer function parameter types
// If the function is recursive you must specify its return type
// Adding *  turns type into a Sequence, eg String* is a zero based collection of strings

// If Integer literal ends with l or L it becomes long
val iAmInt = 1
val iAmLong = 1L

// If floating-point ends with f or F its a float, otherwise its a Double
val iAmDouble = 3.14
val iAmFloat = 3.14f

// There is an experimental genericNumberLiterals feature that allows very large numbers

// Scala has a raw string. You dont need to escape anything but """ in a raw string
// Raw strings preserve spaces so add | pipe to multi line and stripMargin
val raw = """I am a "raw string"/\ and i can do th@t """

val raw2 =
  """|I
     |Am
     |Stripped
     |""".stripMargin


