package com.example.penjualan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bayar.*
import kotlinx.android.synthetic.main.activity_bayar.btnBayar
import kotlinx.android.synthetic.main.activity_okbayar.*

class OkbayarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okbayar)


        btnCetaknota.setOnClickListener {
            startActivity(Intent(this,Nota::class.java))
        }
    }
}