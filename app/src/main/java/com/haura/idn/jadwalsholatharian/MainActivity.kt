package com.haura.idn.jadwalsholatharian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.haura.idn.jadwalsholatharian.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ISholatView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SholatPresenter(this).getDataFromApi("jakarta")


    }

    override fun onDataCompleteFromApi(sholat: Item) {
        tv_subuh.text = sholat.fajr
        tv_dzuhur.text = sholat.dhuhr
        tv_asar.text = sholat.asr
        tv_maghrib.text = sholat.maghrib
        tv_isya.text = sholat.isha

    }

    override fun onDataErorFromApi(throwable: Throwable) {
        error("error ------> ${throwable.localizedMessage}")
//        Toast.makeText(this,"Error ${throwable.localizedMessage}", Toast.LENGTH_SHORT).show()

    }
}
