package com.fortysevendeg.pushover

object Responses {

  class PushoverResponse

  case class MessagePostResponse(status: Int, request: String) extends PushoverResponse

}
