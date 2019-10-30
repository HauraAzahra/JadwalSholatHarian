package com.haura.idn.jadwalsholatharian

import com.haura.idn.jadwalsholatharian.model.Sholat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{city}.json?key=69ace5ae87645e2294d14f0de4cc7610")
    fun getApi(@Path("city") city :String) :
            //panggil Call (retrofit 2)
            Call<Sholat>

    companion object{
        fun create() : RetrofitService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://muslimsalat.com/")
                .build()
            return retrofit.create(RetrofitService ::  class.java)


        }
    }
}