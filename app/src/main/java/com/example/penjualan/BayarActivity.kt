package com.example.penjualan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.penjualan.databinding.ActivityBarangBinding
import kotlinx.android.synthetic.main.activity_bayar.*

class BayarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar)

        btnBayar.setOnClickListener {
            startActivity(Intent(this,OkbayarActivity::class.java))
        }

    }
}