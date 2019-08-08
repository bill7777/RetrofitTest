package tw.com.test.retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tw.com.test.retrofitdemo.models.Suda7

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send_data.setOnClickListener {
            var retrofit = AppClientManager(Config.EZCATURL).getRetrofit()

            val apiService = retrofit.create(ApiService::class.java)
            apiService.suda7("000000000000", "台北市重陽路200號", "").enqueue(object : Callback<Suda7> {
                override fun onResponse(call: Call<Suda7>, response: Response<Suda7>) {
                    val sb = StringBuffer()
                    val suda7 = response.body()

                    sb.append(suda7!!.Code)
                    sb.append("\n")
                    sb.append("---------------------\n")

                    sb.append(suda7.Message)
                    sb.append("\n")
                    sb.append("---------------------\n")

                    sb.append(suda7.Data)
                    sb.append("\n")
                    sb.append("---------------------\n")

                    info.text = sb.toString()
                }

                override fun onFailure(call: Call<Suda7>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
    }
}
