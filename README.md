# Koroutine

> A gentle introduction to coroutines in Kotlin, following [this excellent guide](https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md).

## Usage

### Step 1

First we need to setup a new Kotlin project using [Gradle](https://www.gradle.org) :

```bash
mkdir koroutine
cd koroutine
gradle init
```

Edit `build.gradle` (latest instructions [here](https://kotlinlang.org/docs/reference/using-gradle.html)).  

Basically you need to declare the Kotlin plugin :

```groovy
buildscript {
    ext.kotlin_version = '1.2.0'

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}
```

Then apply it :

```groovy
apply plugin: "kotlin"
```

Finally add the dependency on the Kotlin standard library :

```groovy
repositories {
    mavenCentral()
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}
```

You can now create a file `src/main/kotlin/koroutine.kt` and paste the following code :

```kotlin
fun main(args: Array<String>) {
    println("Hello, World")
}
```

Add the `application` plugin and main class name to your `build.gradle` file :

```groovy
apply plugin: "application"

mainClassName = "KoroutineKt"
```

And run `./gradlew run` to run the application

### Step 2

Kotlin coroutines are experimental for now. We first need to enable them in the build file :

```groovy
kotlin {
    experimental {
        coroutines 'enable'
    }
}
```

For now there are released as a standalone library so we need to also add the required dependency (see [here](https://github.com/Kotlin/kotlinx.coroutines#gradle)):

```groovy
compile 'org.jetbrains.kotlinx:kotlinx-coroutines-core:0.20'
``` 

You can now change the `koroutine.kt` source file to use a coroutine :

```kotlin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    launch {
        delay(1000L)
        println("World")
    }
    println("Hello, ")
    Thread.sleep(2000L)
}
```

As you can see "Hello, " is echoed before "World".  
It is important to note that `launch` doesn't require another thread.  
Notice also how `launch` and `delay` are just standard Kotlin functions.

## Contribute

PRs accepted.

## License

MIT © Benoît Giraudou
