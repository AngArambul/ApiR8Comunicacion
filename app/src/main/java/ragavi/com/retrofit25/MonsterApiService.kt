package ragavi.com.retrofit25

import retrofit2.Call
import retrofit2.http.GET

interface MonsterApiService {
    @GET("monstersanctuary/monsters")
    fun getMonsters(): Call<List<Monster>>
}