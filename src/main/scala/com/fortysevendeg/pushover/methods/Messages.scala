package com.fortysevendeg.pushover.methods

import com.fortysevendeg.pushover._
import Responses._

class Messages(httpClient: HttpClient, apiToken: String) {

  def post(
      user: String,
      message: String,
      device: Option[String] = None,
      title: Option[String] = None,
      url: Option[String] = None,
      url_title: Option[String] = None,
      priority: Option[Priorities.Value] = None,
      timestamp: Option[String] = None,
      sound: Option[Sounds.Value] = None,
      html: Option[HtmlFormat.Value] = Option(HtmlFormat.On),
      retry: Option[Int] = None,
      expire: Option[Int] = None): SendMessageResponse = {

    val requiredParams = Map("token" -> apiToken, "user" -> user, "message" -> message)

    val data = requiredParams ++
        device.map(x => Map("device" -> x)).getOrElse(Map.empty) ++
        title.map(x => Map("title" -> x)).getOrElse(Map.empty) ++
        url.map(x => Map("url" -> x)).getOrElse(Map.empty) ++
        url_title.map(x => Map("url_title" -> x)).getOrElse(Map.empty) ++
        priority.map(x => Map("priority" -> x.id.toString)).getOrElse(Map.empty) ++
        timestamp.map(x => Map("timestamp" -> x)).getOrElse(Map.empty) ++
        sound.map(x => Map("sound" -> x.toString)).getOrElse(Map.empty) ++
        html.map(x => Map("html" -> x.id.toString)).getOrElse(Map.empty) ++
        retry.map(x => Map("retry" -> x.toString)).getOrElse(Map.empty) ++
        expire.map(x => Map("expire" -> x.toString)).getOrElse(Map.empty)

    val responseDict = httpClient.post("messages.json", data)

    SendMessageResponse(
      (responseDict \ "status").as[Int],
      (responseDict \ "request").as[String],
      (responseDict \ "errors").asOpt[Seq[String]],
      (responseDict \ "receipt").asOpt[String])
  }


  def receipts(receipt: String): ReceiptsMessageResponse = {

    val responseDict = httpClient.get(s"receipts/$receipt.json", Map("token" -> apiToken))

    ReceiptsMessageResponse(
      (responseDict \ "status").as[Int],
      (responseDict \ "request").as[String],
      (responseDict \ "errors").asOpt[Seq[String]],
      (responseDict \ "acknowledged").asOpt[Int],
      (responseDict \ "acknowledged_at").asOpt[Int],
      (responseDict \ "acknowledged_by").asOpt[String],
      (responseDict \ "acknowledged_by_device").asOpt[String],
      (responseDict \ "last_delivered_at").asOpt[Int],
      (responseDict \ "expired").asOpt[Int],
      (responseDict \ "expires_at").asOpt[Int],
      (responseDict \ "called_back").asOpt[Int],
      (responseDict \ "called_back_at").asOpt[Int])

  }


  def cancel(receipt: String): CancelMessageResponse = {

    val responseDict = httpClient.post(s"receipts/$receipt/cancel.json", Map("token" -> apiToken))

    CancelMessageResponse(
      (responseDict \ "status").as[Int],
      (responseDict \ "request").as[String],
      (responseDict \ "errors").asOpt[Seq[String]])
  }

}
