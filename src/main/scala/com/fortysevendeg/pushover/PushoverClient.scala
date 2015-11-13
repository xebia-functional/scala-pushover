package com.fortysevendeg.pushover

import com.fortysevendeg.pushover.methods.Messages


class PushoverClient(private val apiToken: String) {

  protected val httpClient = new HttpClient()

  val messages = new Messages(httpClient, apiToken)

}
