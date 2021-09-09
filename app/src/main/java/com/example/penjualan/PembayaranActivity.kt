package com.example.penjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.penjualan.databinding.ActivityPembayaranBinding
import com.example.penjualan.databinding.ActivityDashboardBinding

class PembayaranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPembayaranBinding

    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        actionBar = supportActionBar!!
        actionBar.title = "Pembayaran"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}