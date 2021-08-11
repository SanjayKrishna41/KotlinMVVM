package `in`.example.kotlinmvvm.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class UserModel(
    var email: String? = null,
    var password: String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uid:Int = CURRENT_USER_ID
}