// case object is a regular singleton object where compiler overrides toString
// toString in case object produces human readable output

case object Cat {
  val name:String = "Tom"
}
println(Cat) // Cat