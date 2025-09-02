package com.depositoamerica.app.repositories
import com.depositoamerica.app.data.models.UserProfile
class AuthRepository {
    private val defaultUser = UserProfile("admin", "123")
    fun login(username: String, password: String): Boolean =
        username == defaultUser.username && password == defaultUser.password
}