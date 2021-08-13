package `in`.example.kotlinmvvm.ui.model

/**
 * Entity of ContestResponse class
 * Model class to store banner data
 */
data class BannerModel(
    val image: String? = null,
    val bannerId: Int? = null,
    val share: String? = null,
    val id: String? = null,
    val position: String? = null,
    var url: String? = null
)