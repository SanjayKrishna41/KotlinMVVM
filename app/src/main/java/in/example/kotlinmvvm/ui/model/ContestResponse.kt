package `in`.example.kotlinmvvm.ui.model

/**
 * Main response for getting contest details
 */
data class ContestResponse(
    val contests: List<ContestsModel>,
    val myContest: List<MyContestModel>,
    val groups: List<GroupModel>,
    val banners: List<BannerModel>
)