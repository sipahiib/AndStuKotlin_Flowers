package com.sipahi.cicekbahcesi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cicekler_detay.*

class CiceklerDetay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicekler_detay)

        var bundle: Bundle? = intent.extras
        var adi: String? = bundle!!.getString("adi")
        var aciklama:String? = bundle!!.getString("aciklama")
        var resim = bundle.getInt("resim")

        detayAdi.text=adi
        detayAciklama.text=aciklama
        detayResim.setImageResource(resim)

    }
}