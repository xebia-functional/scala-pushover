package com.fortysevendeg.pushover

object Exceptions {

  class PushoverError extends Exception

  class InvalidTokenError extends PushoverError

  class InvalidUserError extends PushoverError

  class BlankMessageError extends PushoverError

  class UnknownPushoverError(msg: String) extends Exception(msg)

}
