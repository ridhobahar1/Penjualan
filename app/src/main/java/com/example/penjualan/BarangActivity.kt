package com.example.penjualan

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class BarangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        val headingBarang : TextView = findViewById(R.id.heading)


        val bundle: Bundle?= intent.extras
        val heading = bundle!!.getString("heading")



    }
}