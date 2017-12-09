import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    val job = launch { printWorld() }
    println("Hello, ")
    job.join()
}

suspend private fun printWorld() {
    delay(1000L)
    println("World")
}
