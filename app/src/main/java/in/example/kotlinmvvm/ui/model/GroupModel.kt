package `in`.example.kotlinmvvm.ui.model

/**
 * Entity of ContestResponse class
 * Model class to store group data
 */
data class GroupModel(
    var id: String? = null,
    var position:Int = 0,
    var key: String? = null,
    var label: String? = null,
    var enable:Int = 0
)