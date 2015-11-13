import com.fortysevendeg.pushover.{HttpClient, Exceptions}
import Exceptions._
import org.scalatest._
import play.api.libs.json.Json

class HttpClientSpec extends WordSpec with Matchers with BeforeAndAfterEach with PrivateMethodTester {

  val httpClient = new HttpClient()
  val checkResponse = PrivateMethod[String]('checkResponse)

  "checkResponse()" should {

    "raise no error if \"status\" is 1" in {
      val response = Json.parse(
        """
          | { "status" : 1 }
        """.stripMargin)

      noException should be thrownBy (httpClient invokePrivate checkResponse(response))
    }


    "raise an InvalidTokenError if the token error is received" in {
      val response = Json.parse(
        """
          | {
          |   "status" : 0,
          |   "errors" : ["error"],
          |   "token": "invalid"
          | }
        """.stripMargin)

      an[InvalidTokenError] should be thrownBy (httpClient invokePrivate checkResponse(response))
    }

    "raise an InvalidUserError if the user error is received" in {
      val response = Json.parse(
        """
          | {
          |   "status" : 0,
          |   "errors" : ["error"],
          |   "user": "invalid"
          | }
        """.stripMargin)

      an[InvalidUserError] should be thrownBy (httpClient invokePrivate checkResponse(response))
    }

    "raise an BlankMessageError if the message error is received" in {
      val response = Json.parse(
        """
          | {
          |   "status" : 0,
          |   "errors" : ["error"],
          |   "message": "cannot be blank"
          | }
        """.stripMargin)

      an[BlankMessageError] should be thrownBy (httpClient invokePrivate checkResponse(response))
    }

    "raise an UnknownPushoverError if the unknown error is received" in {
      val response = Json.parse(
        """
          | {
          |   "status" : 0,
          |   "errors" : null
          | }
        """.stripMargin)

      an[UnknownPushoverError] should be thrownBy (httpClient invokePrivate checkResponse(response))
    }

  }


}
