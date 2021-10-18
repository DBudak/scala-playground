// Instances of org.http4s.HttpRoutes are endpoints
// Each HttpRoutes uses partial functions to match incoming request
// Each endpoint hit produces a response and a side effect
// cats.effect.IO is a representation of sync and async side effects
// A singleton object that extends cats.effect.IOApp with instructions on port and host to bind services
// Executable is also using http4s/blaze as backend for network IO