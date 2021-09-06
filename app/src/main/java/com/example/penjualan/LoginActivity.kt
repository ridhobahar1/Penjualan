package com.example.penjualan

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.penjualan.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    //viewbinding
    private lateinit var binding:ActivityLoginBinding

    //actionBar
    private lateinit var actionBar: ActionBar

    //progressDialog
    private lateinit var progresDialog:ProgressDialog

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure actionbar
        actionBar = supportActionBar!!
        actionBar.title = "Login"

            //configure progress dialog
        progresDialog = ProgressDialog(this)
        progresDialog.setTitle("Please Wait")
        progresDialog.setMessage("Loggin In..")
        progresDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click regis
        binding.noAccountTv.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        //handle click login
        binding.loginBtn.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        //get Data
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEt.error = "Invalid email format"
        }
        else if(TextUtils.isEmpty(password)){
            binding.passwordEt.error = "Please enter Password"
        }
        else {
            //data valid, go login
            firebaseLogin()
        }
    }

    private fun firebaseLogin(){
        //show progress
        progresDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                //loginsucces
                progresDialog.dismiss()

                //getuserinfo
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Logged In as $email", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener {e->
                //login failed
                progresDialog.dismiss()
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser(){
        //if user is already go to profil activity
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}