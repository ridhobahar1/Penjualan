package com.example.penjualan

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_penjualan.*

class PenjualanActivity : AppCompatActivity() {

    private lateinit var actionBar: ActionBar

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Barang>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var hargaBarang: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjualan)
        actionBar = supportActionBar!!
        actionBar.title = "Penjualan"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //__________________________________________________
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g
        )

        heading = arrayOf(
            "Keyboard Asus RGB Mechanical",
            "Monitor Curve Samsung HD",
            "SSD WD Blue 1 TB SATA",
            "Harddisk SEAGATE BarraCuda 1TB",
            "Mouse HP Gaming RGB",
            "Mouse Pad Gaming HP RGB",
            "Graphic Card MSI Gaming Trio X 3090",
        )
        hargaBarang = arrayOf(
            250000,
            1500000,
            500000,
            1200000,
            120000,
            90000,
            10000000
        )

        newRecyclerView = findViewById(R.id.rv_recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Barang>()
        getUserdata()



    }
    private fun getUserdata(){

        for (i in imageId.indices){
            val barang = Barang(imageId[i],heading[i],hargaBarang[i])
            newArrayList.add(barang)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)

    }




}