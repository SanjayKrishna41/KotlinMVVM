package `in`.example.kotlinmvvm.ui.model

/**
 * Entity of ContestResponse class
 * Model to hold all the contest details
 */
data class ContestsModel(
    var id:Int = 0,
    var fixtureId:Int = 0,
    var masterfixtureid:Int = 0,
    var title: String? = null,
    var startTime: String? = null,
    var endTime: String? = null,
    var contestList: ContestListModel? = null,
    var contest: List<ContestModel>? = null
)