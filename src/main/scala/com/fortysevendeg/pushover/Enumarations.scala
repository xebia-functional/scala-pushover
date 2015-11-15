package com.fortysevendeg.pushover

object Priorities extends Enumeration {
  val LowestPriority = Value(-2)
  val LowPriority = Value(-1)
  val NormalPriority = Value(0)
  val HighPriority = Value(1)
  val EmergencyPriority = Value(2)
}

object Sounds extends Enumeration {
  val Pushover = Value("pushover")
  val Bike = Value("bike")
  val Bugle = Value("bugle")
  val CashRegister = Value("cashregister")
  val Classical = Value("classical")
  val Cosmic = Value("cosmic")
  val Falling = Value("falling")
  val Gamelan = Value("gamelan")
  val Incoming = Value("incoming")
  val Intermission = Value("intermission")
  val Magic = Value("magic")
  val Mechanical = Value("mechanical")
  val PianoBar = Value("pianobar")
  val Siren = Value("siren")
  val SpaceAlarm = Value("spacealarm")
  val TugBoat = Value("tugboat")
  val AlienAlarm = Value("alien")
  val Climb = Value("climb")
  val Persistent = Value("persistent")
  val PushoverEcho = Value("echo")
  val UpDown = Value("updown")
  val None = Value("none")
}

object HtmlFormat extends Enumeration {
  val Off = Value(0)
  val On = Value(1)
}

