package `in`.example.kotlinmvvm.ui.model

class SingleResponse<T> {
    var status: String? = null
    var message: String? = null
    var data: T? = null
}