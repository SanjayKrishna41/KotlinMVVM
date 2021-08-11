package `in`.example.kotlinmvvm.data.db

import `in`.example.kotlinmvvm.ui.model.CURRENT_USER_ID
import `in`.example.kotlinmvvm.ui.model.UserModel
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user:UserModel) : Long

    @Query("Select * from UserModel where uid=$CURRENT_USER_ID")
    fun getUser() : LiveData<UserModel>

}