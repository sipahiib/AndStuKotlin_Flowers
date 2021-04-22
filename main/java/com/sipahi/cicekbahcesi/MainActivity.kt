package com.sipahi.cicekbahcesi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cicek_karti.view.*
import java.sql.Array

class MainActivity : AppCompatActivity() {

    var list = ArrayList<Cicekler>()
    var adaptor: CiceklerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(Cicekler("Pembe", "Pembe Çiçeği", R.drawable.c1))
        list.add(Cicekler("Dudak", "Dudak Çiçeği", R.drawable.c2))
        list.add(Cicekler("Mavi", "Mavi Çiçeği", R.drawable.c3))

        adaptor = CiceklerAdapter(this,list)
        listView.adapter = adaptor
    }

    class CiceklerAdapter : BaseAdapter {

        var List = ArrayList<Cicekler>()
        var context: Context? = null

        constructor(context: Context, List: ArrayList<Cicekler>) : super() {
            this.context = context
            this.List = List
        }

        override fun getCount(): Int {
            return List.size
        }

        override fun getItem(position: Int): Any {
            return List[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posCicekler = List[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var cicekKarti = inflator.inflate(R.layout.cicek_karti, null)
            cicekKarti.kartAdi.text = posCicekler.adi
            cicekKarti.kartAciklama.text = posCicekler.aciklama
            cicekKarti.kartResim.setImageResource(posCicekler.resim!!)

            cicekKarti.kartResim.setOnClickListener()
            {
                var intent=Intent(context, CiceklerDetay::class.java)
                intent.putExtra("adi", posCicekler.adi)
                intent.putExtra("aciklama", posCicekler.aciklama)
                intent.putExtra("resim", posCicekler.resim!!)

                context!!.startActivity(intent)
            }

            return cicekKarti
        }
    }
}