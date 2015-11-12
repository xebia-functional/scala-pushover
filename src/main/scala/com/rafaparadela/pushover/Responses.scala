package com.rafaparadela.pushover

object Responses {

  class PushoverResponse

  case class MessagePostResponse(status: Int, request: String) extends PushoverResponse

}
