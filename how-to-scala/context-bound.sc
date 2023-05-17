// Used with typeclasses

// A context bound is an annotation on a generic type variable like so:
// [A : Context]
// It expands into a generic type parameter [A] along with an implicit parameter for a Context[A].
def pageTemplate[A : HtmlWriter](body: A): String = {
  val renderedBody = body.toHtml

  s"<html><head>...</head><body>${renderedBody}</body></html>"
}

// Is equivalent to
def pageTemplate[A](body: A)(implicit writer: HtmlWriter[A]): String = {
  val renderedBody = body.toHtml

  s"<html><head>...</head><body>${renderedBody}</body></html>"
}
// but we don't use writer in the class so we can context bound it and tell compiler to search for implicit variables of
// type HtmlWriter

// Context bounds give us a short-hand syntax for declaring implicit parameters, but since we don’t have an explicit
//  name for the parameter we cannot use it in our methods.

// If we do need access to it we can use keyword implicitly

case class Example(name: String)
implicit val implicitExample = Example("implicit")

implicitly[Example]