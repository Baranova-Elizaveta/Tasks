fun main() {
    val apiManager = ApiManager()
    val cacheManager = CacheManager()
    val userManager = UserManager(apiManager, cacheManager)

    val userId = 12

    val userData = userManager.getUserData(userId)

    println(userData)
}
data class UserData(val userId: Int, val name: String, val email: String)

// Класс для работы с данными пользователя
class UserManager(private val apiManager: ApiManager, private val cacheManager: CacheManager) {
    fun getUserData(userId: Int): UserData {

        val cachedData = cacheManager.getCachedUserData(userId)
        if (cachedData != null) {
            return cachedData
        } else {

            val apiData = apiManager.getUserData(userId)

            cacheManager.cacheUserData(userId, apiData)

            return apiData
        }
    }
}

// Класс для работы с данными из Api
class ApiManager {
    fun getUserData(userId: Int): UserData {
        // Например, здесь мы создадим фиктивные данные для пользователя.
        val apiData = UserData(userId, "John", "johndoe@example.com")
        return apiData
    }

}

// Класс для работы с кешем
class CacheManager {
    private val cache = mutableMapOf<Int, UserData>()
    fun getCachedUserData(userId: Int): UserData? {
        return cache[userId]
    }

    fun cacheUserData(userId: Int, userData: UserData) {
        cache[userId] = userData
    }
}


