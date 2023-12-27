package com.example.pet_booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pet_booking.databinding.ActivityChatBinding
import com.example.pet_booking.databinding.ActivityPetBinding

class PetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetBinding.inflate(layoutInflater)
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