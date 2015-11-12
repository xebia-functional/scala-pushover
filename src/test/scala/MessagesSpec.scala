import com.rafaparadela.pushover.HttpClient
import com.rafaparadela.pushover.methods.Messages
import org.scalatest._
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import play.api.libs.json.Json

class MessagesSpec extends WordSpec with Matchers with MockitoSugar {

  val testApiKey = "TEST_API_KEY"
  val testUser = "USER_KEY"
  val testMessage = "This is a test."
  val testTitle = "This is a title"
  val testPostReturnedRequest = "11111111111"

  val methodSegment = "messages.json"

  val validResponse = s"""
                         |{
                         |    "status": 1,
                         |    "request": "$testPostReturnedRequest"
                         |}""".stripMargin

  val mockHttpClient = mock[HttpClient]

  val messages = new Messages(mockHttpClient, testApiKey)

  "Messages.post()" should {

    "submit a message when data is the minimal required" in {

      val testData = Map("token" -> testApiKey, "user" -> testUser, "message" -> testMessage)

      when(mockHttpClient.post(methodSegment, testData)).thenReturn(Json.parse(validResponse))

      val response = messages.post(testUser, testMessage)

      response.status shouldBe 1
      response.request shouldBe testPostReturnedRequest

      verify(mockHttpClient).post(methodSegment, testData)
    }

    "submit a message when some optional value are passed in data" in {

      val testData = Map("token" -> testApiKey, "user" -> testUser, "message" -> testMessage, "title" -> testTitle)

      when(mockHttpClient.post(methodSegment, testData)).thenReturn(Json.parse(validResponse))

      val response = messages.post(user = testUser, message = testMessage, title = Some(testTitle))

      response.status shouldBe 1
      response.request shouldBe testPostReturnedRequest

      verify(mockHttpClient).post(methodSegment, testData)
    }

  }


}
