package `in`.example.kotlinmvvm.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// object is static in java
object Coroutines{

    fun main(work:suspend (()->Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }

    fun io(work:suspend (()->Unit)) = CoroutineScope(Dispatchers.IO).launch {
        work()
    }
}