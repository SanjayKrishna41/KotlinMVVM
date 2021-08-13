package `in`.example.kotlinmvvm.ui.model

/**
 * Entity of ContestListModel class
 * Model class for storing single contest data
 */
data class ContestModel(
    var contestId: Int = 0,
    var mastercontestId: String? = null,
    var masterContestId: Int = 0,
    var title: String? = null,
    var group: String? = null,
    var groupLabel: String? = null,
    var fixtureName: String? = null,
    var prize: String? = null,
    var price: Any? = null,
    var team: Int = 0,
    var spotLeft: Int = 0,
    var entryprice: Int = 0,
    var fixtureId: Int = 0,
    var adminfee: Any? = null,
    var instructions: String? = null,
    var fixture: String? = null,
    var distribute: Int = 0,
    var startTime: String? = null,
    var endTime: String? = null,
    var winning: Int = 0,
    var rank: Int = 0,
    var points: Int = 0,
    var position: Int = 0,
    var status: String? = null,
    var portfolioLimit: Int = 0,
    var firstPrize: Int = 0,
    var bysosPoints: Int = 0
)