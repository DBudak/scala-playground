package com.example.sbtrest

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    SbtrestServer.stream[IO].compile.drain.as(ExitCode.Success)
}
