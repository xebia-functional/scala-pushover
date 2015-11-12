package com.rafaparadela.pushover

import com.rafaparadela.pushover.methods.Messages


class PushoverClient(private val apiToken: String) {

  protected val httpClient = new HttpClient()

  val messages = new Messages(httpClient, apiToken)

}
