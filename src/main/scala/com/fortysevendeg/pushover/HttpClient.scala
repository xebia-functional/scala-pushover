package com.fortysevendeg.pushover

import play.api.libs.json.{Json, JsValue}
import scalaj.http.{Http, HttpOptions}

class HttpClient(baseURL: String = "http://api.pushover.net", apiVersion: String = "1") {

  import Exceptions._

  private val connTimeoutMs: Int = 100
  private val readTimeoutMs: Int = 500

  private def buildURL(method: String) = s"$baseURL/$apiVersion/$method"

  private def checkResponse(responseJSON: JsValue) {

    if ((responseJSON \ "status").asOpt[Int].contains(1))
      return

    (responseJSON \ "errors").asOpt[Seq[String]] match {
      case Some(x) => {
        if ((responseJSON \ "token").asOpt[String].contains("invalid")) throw new InvalidTokenError
        if ((responseJSON \ "user").asOpt[String].contains("invalid")) throw new InvalidUserError
        if ((responseJSON \ "message").asOpt[String].contains("cannot be blank")) throw new BlankMessageError
      }
      case None => throw new UnknownPushoverError(s"Invalid response from Pushover server: $responseJSON")
    }
  }

  def post(method: String, data: Map[String, String]): JsValue = {
    val result = Json.parse(Http(buildURL(method))
        .postForm
        .option(HttpOptions.connTimeout(connTimeoutMs))
        .option(HttpOptions.readTimeout(readTimeoutMs))
        .params(data)
        .asString.body)

    checkResponse(result)

    result
  }

}
