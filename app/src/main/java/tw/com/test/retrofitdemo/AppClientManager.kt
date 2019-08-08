package tw.com.test.retrofitdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager constructor(url: String) {
    private var url: String = url

//    private var logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
//        override fun log(message: String) {
//            Log.i("interceptor msg", message)
//        }
//    })

//    private var okHttpClient : OkHttpClient

//    init {
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        okHttpClient = OkHttpClient().newBuilder().addInterceptor(logging).build()
//        retrofit = Retrofit.Builder()
//                .baseUrl(Config.URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build()
//    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(this.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}

