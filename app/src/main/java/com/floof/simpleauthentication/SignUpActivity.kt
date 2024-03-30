package com.floof.simpleauthentication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.floof.simpleauthentication.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {
    private val successMessage = "You have created your account. Check your email to verify it!"
    private val mismatchMessage = "The passwords you've entered don't match."

    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener { signUp() }
        binding.toSignInButton.setOnClickListener { finish() }
    }

    private fun signUp() {
        val email = binding.emailSignUpField.text.toString()
        val password = binding.passField.text.toString()
        val repeatPassword = binding.repeatPassField.text.toString()

        if (password == repeatPassword) {
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { showMessage(successMessage) ; finish() }
                .addOnFailureListener { showMessage(it.message!!) }
        } else { showMessage(mismatchMessage) }
    }

    private fun showMessage(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}