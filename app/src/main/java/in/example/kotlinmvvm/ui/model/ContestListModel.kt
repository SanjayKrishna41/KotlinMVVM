package `in`.example.kotlinmvvm.ui.model

/**
 * Entity of Contests Model class
 * Model class for storing contests based on category
 * 1. mega 2. beginners 3. head-to-head 4.give away 5. winner takes all
 */
data class ContestListModel(
    var megaContests: List<ContestModel>? = null,
    var beginnersContests: List<ContestModel>? = null,
    var practiceContests: List<ContestModel>? = null,
    var headToHead: List<ContestModel>? = null,
    var giveAway: List<ContestModel>? = null,
    var winnerTakesAll: List<ContestModel>? = null
)