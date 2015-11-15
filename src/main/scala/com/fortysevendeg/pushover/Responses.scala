package com.fortysevendeg.pushover

object Responses {

  class PushoverResponse

  case class MessagePostResponse(status: Int, request: String, errors: Option[Seq[String]] = None) extends PushoverResponse

}
