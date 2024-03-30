package com.floof.simpleauthentication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.floof.simpleauthentication.databinding.ActivityMainmenuBinding

class MainMenuActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainmenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.emailText.text = intent.getStringExtra("email")
        binding.logoutButton.setOnClickListener { finish() }
    }
}