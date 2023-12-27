package com.example.pet_booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pet_booking.databinding.ActivityChatBinding
import com.example.pet_booking.databinding.ActivitySearchBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.search_button -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                }
                R.id.chat_button -> {
                    val intent = Intent(this, ChatActivity::class.java)
                    startActivity(intent)
                }

                R.id.profile_button -> {
                    val intent = Intent(this, PetActivity::class.java)
                    startActivity(intent)
                }
            }
            true

        }
    }
}
