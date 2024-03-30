package com.floof.simpleauthentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.floof.simpleauthentication.databinding.ActivitySigninBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class SignInActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySigninBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener { signIn() }
        binding.toSignUpButton.setOnClickListener { signUp() }
    }

    private fun signIn() {
        val email = binding.emailSignInField.text.toString()
        val password = binding.passwordField.text.toString()

        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { startMainMenu(it.user) }
            .addOnFailureListener { showMessage(it.message!!) }
    }

    private fun startMainMenu(user: FirebaseUser?) {
        val intent = Intent(this, MainMenuActivity::class.java).apply {
            putExtra("email", user!!.email)
        }
        startActivity(intent)
    }

    private fun showMessage(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun signUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}