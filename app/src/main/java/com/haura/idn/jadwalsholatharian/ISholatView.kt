package com.haura.idn.jadwalsholatharian

import com.haura.idn.jadwalsholatharian.model.Item
import com.haura.idn.jadwalsholatharian.model.Sholat

interface ISholatView {

    //function untuk berhasil
    fun onDataCompleteFromApi(sholat: Item)

    //function untuk eror
    fun onDataErorFromApi(throwable: Throwable)
}