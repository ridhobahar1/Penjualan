package com.example.penjualan

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.penjualan.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    //viewbinding
    private lateinit var binding: ActivitySignUpBinding

    //actionBar
    private lateinit var actionBar: ActionBar

    //progressDialog
    private lateinit var progresDialog: ProgressDialog

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //config actionbar
        actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //config progress dialog
        progresDialog = ProgressDialog(this)
        progresDialog.setTitle("Please Wait")
        progresDialog.setMessage("Creating account In..")
        progresDialog.setCanceledOnTouchOutside(false)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpBtn.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        email =  binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEt.error = "invalid email format"
        }
        else if(TextUtils.isEmpty(password)){
            binding.passwordEt.error = "please enter password"
        }
        else if (password.length <6){
            binding.passwordEt.error = "password must atleast 6 character long"
        }
        else{
            firebaseSignUp()
        }
    }

    fun firebaseSignUp(){
        progresDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                progresDialog.dismiss()
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Account created with email $email", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this,DashboardAcitivty::class.java))
                finish()
            }
            .addOnFailureListener { e->
                progresDialog.dismiss()
                Toast.makeText(this,"signup failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}