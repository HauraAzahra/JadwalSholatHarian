package com.haura.idn.jadwalsholatharian

import android.content.Context
import com.haura.idn.jadwalsholatharian.model.Item
import com.haura.idn.jadwalsholatharian.model.Sholat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SholatPresenter(context: Context) {
    val sholatView = context as ISholatView

    fun getDataFromApi(city : String){
        RetrofitService.create()
            .getApi(city)
             //Callback retrofit 2
            .enqueue(object : Callback<Sholat>{
                override fun onFailure(call: Call<Sholat>, t: Throwable) {
                    sholatView.onDataErorFromApi(t)
                }

                override fun onResponse(call: Call<Sholat>, response: Response<Sholat>) {
                    sholatView.onDataCompleteFromApi(response.body()?.items?.get(0) as Item)
                }

            })

    }

}