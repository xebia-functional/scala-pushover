package com.fortysevendeg.pushover

object Responses {

  abstract class PushoverResponse {
      def status: Int
      def request: String
      def errors: Option[Seq[String]]
  }

  case class SendMessageResponse(
      status: Int,
      request: String,
      errors: Option[Seq[String]] = None,
      receipt: Option[String] = None) extends PushoverResponse

  case class ReceiptsMessageResponse(
      status: Int,
      request: String,
      errors: Option[Seq[String]] = None,
      acknowledged: Option[Int] = None,
      acknowledged_at: Option[Int] = None,
      acknowledged_by: Option[String] = None,
      acknowledged_by_device: Option[String] = None,
      last_delivered_at: Option[Int] = None,
      expired: Option[Int] = None,
      expires_at: Option[Int] = None,
      called_back: Option[Int] = None,
      called_back_at: Option[Int] = None) extends PushoverResponse

  case class CancelMessageResponse(
      status: Int,
      request: String,
      errors: Option[Seq[String]] = None) extends PushoverResponse

}
