package com.fortysevendeg.pushover

import play.api.libs.json.{Json, JsValue}
import scalaj.http.{Http, HttpOptions}

class HttpClient(baseURL: String = "https://api.pushover.net", apiVersion: String = "1") {

  private val connTimeoutMs: Int = 1000
  private val readTimeoutMs: Int = 5000

  private def buildURL(method: String) = s"$baseURL/$apiVersion/$method"

  def post(method: String, data: Map[String, String]): JsValue = Json.parse(Http(buildURL(method))
        .postForm
        .option(HttpOptions.connTimeout(connTimeoutMs))
        .option(HttpOptions.readTimeout(readTimeoutMs))
        .params(data)
        .asString.body)


  def get(method: String, data: Map[String, String]): JsValue = Json.parse(Http(buildURL(method))
        .option(HttpOptions.connTimeout(connTimeoutMs))
        .option(HttpOptions.readTimeout(readTimeoutMs))
        .params(data)
        .asString.body)


}
