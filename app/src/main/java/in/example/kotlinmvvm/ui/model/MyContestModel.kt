package `in`.example.kotlinmvvm.ui.model

/**
 * Entity of ContestResponse class
 * Model class to store my contest related data
 */
data class MyContestModel(
    var id:Int = 0,
    var fixtureId:Int = 0,
    var masterfixtureid:Int = 0,
    var title: String? = null,
    var startTime: String? = null,
    var endTime: String? = null,
    var contest: List<Any>? = null,
    var contestList: ContestListModel? = null
)