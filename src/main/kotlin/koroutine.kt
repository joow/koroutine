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
