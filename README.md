# scala-pushover

scala-pushover is a simple, extensible client library for Scala that provides an interface to the [Pushover](https://pushover.net) API

_Note: scala-pushover is a partial implementation of the Pushover API. The Pushover API is under heavy development, and this library
is subject to frequent change._

### Supported Methods

 - messages.post

## Download

scala-slack is listed on Maven Central and can be included in your project by adding this line to your build.sbt:
```
libraryDependencies += "com.flyberrycapital" %% "scala-slack" % "0.3.0"
```
scala-slack supports Scala 2.10 and 2.11.

## Usage

First, instantiate a PushoverClient object.

```scala
import com.rafaparadela.pushover.PushoverClient

val p = new PushoverClient(<YOUR_API_TOKEN>)
```

You can then use Pushove API methods:

```scala
p.messages.post(<USER_KEY>, "Hello World!")
```

This particular method accepts:

- token (required) - your application's API token
- `user (required) - the user/group key (not e-mail address) of your user (or you), viewable when logged into our dashboard (often referred to as USER_KEY in our documentation and code examples)
- message (required) - your message
- Some optional parameters may be included:
- device - your user's device name to send the message directly to that device, rather than all of the user's devices (multiple devices may be separated by a comma)
- title - your message's title, otherwise your app's name is used
- url - a supplementary URL to show with your message
- url_title - a title for your supplementary URL, otherwise just the URL is shown
- priority - send as -2 to generate no notification/alert, -1 to always send as a quiet notification, 1 to display as high-priority and bypass the user's quiet hours, or 2 to also require confirmation from the user
- timestamp - a Unix timestamp of your message's date and time to display to the user, rather than the time your message is received by our API
- sound - the name of one of the sounds supported by device clients to override the user's default sound choice




## License

This project is licensed under the [MIT license](http://opensource.org/licenses/MIT).
