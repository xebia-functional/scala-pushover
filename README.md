# scala-pushover

scala-pushover is a simple, extensible client library for Scala that provides an interface to the [Pushover](https://pushover.net) API

_Note: scala-pushover is a partial implementation of the Pushover API. The Pushover API is under heavy development, and this library
is subject to frequent change._

### Supported Methods

 - messages.post

## Download

scala-pushover is listed on Maven Central and can be included in your project by adding this line to your build.sbt:
```
libraryDependencies += "com.fortysevendeg" %% "scala-pushover" % "0.1"
```
scala-pushover supports Scala 2.10 and 2.11.

## Usage

First, instantiate a PushoverClient object.

```scala
import com.fortysevendeg.pushover.PushoverClient

val p = new PushoverClient(<YOUR_API_TOKEN>)
```

You can then use Pushove API methods:

```scala
p.messages.post(user = <USER_KEY>, message = "Hello World!")
```

This particular method requires those parameters:

- `user` (required) - the user/group key (not e-mail address) of your user (or you), viewable when logged into our dashboard (often referred to as `USER_KEY` in our documentation and code examples)
- `message` (required) - your message

Some optional parameters may be included:

- `device` - your user's device name to send the message directly to that device, rather than all of the user's devices (multiple devices may be separated by a comma)
- `title` - your message's title, otherwise your app's name is used
- `url` - a supplementary URL to show with your message
- `url_title` - a title for your supplementary URL, otherwise just the URL is shown
- `timestamp` - a Unix timestamp of your message's date and time to display to the user, rather than the time your message is received by our API
- `sound` - the name of one of the sounds supported by device clients to override the user's default sound choice
- `html` - to enable HTML formatting, include an html parameter set to 1. The normal message content in your message parameter will then be displayed as HTML. (Default value: 1)
- `priority` - send as -2 to generate no notification/alert, -1 to always send as a quiet notification, 1 to display as high-priority and bypass the user's quiet hours, or 2 to also require confirmation from the user (To send an emergency-priority notification, the priority parameter must be set to 2 and the retry and expire parameters must be supplied.)

When sending notifications through the Pushover API, the sound parameter may be set to one of the following:

- `pushover` - Pushover (default)
- `bike` - Bike
- `bugle` - Bugle
- `cashregister` - Cash Register
- `classical` - Classical
- `cosmic` - Cosmic
- `falling` - Falling
- `gamelan` - Gamelan
- `incoming` - Incoming
- `intermission` - Intermission
- `magic` - Magic
- `mechanical` - Mechanical
- `pianobar` - Piano Bar
- `siren` - Siren
- `spacealarm` - Space Alarm
- `tugboat` - Tug Boat
- `alien` - Alien Alarm (long)
- `climb` - Climb (long)
- `persistent` - Persistent (long)
- `echo` - Pushover Echo (long)
- `updown` - Up Down (long)
- `none` - None (silent)




## License

This project is licensed under the [MIT license](http://opensource.org/licenses/MIT).