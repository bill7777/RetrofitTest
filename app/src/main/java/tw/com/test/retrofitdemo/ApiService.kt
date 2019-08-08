package tw.com.test.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tw.com.test.retrofitdemo.models.Suda7

interface ApiService {
    @GET("api/tds/AskSuda7v2")
    fun suda7(@Query("CustID") CustID: String, @Query("CustAddress") CustAddress: String, @Query("GetSuda7_dashv2") GetSuda7_dashv2: String): Call<Suda7>
}
