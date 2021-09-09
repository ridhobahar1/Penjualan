package com.example.penjualan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.penjualan.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardAcitivty : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    private lateinit var actionBar: ActionBar

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar = supportActionBar!!
        actionBar.title = "Profile"

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()


        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        binding.BtnPembayaran.setOnClickListener {
            startActivity(Intent(this, PembayaranActivity::class.java))

        }
        binding.BtnPenjualan.setOnClickListener {
            startActivity(Intent(this, PenjualanActivity::class.java))

        }
        binding.BtnUser.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))

        }



    }

    private fun checkUser(){
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            val email = firebaseUser.email
            binding.emailTv.text = email

        }else{

            startActivity(Intent(this,LoginActivity::class.java))
            finish()

        }
    }


}