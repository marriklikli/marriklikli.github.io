package com.example.pet_booking

import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator



class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val relativeLayout = findViewById<RelativeLayout>(R.id.background)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val animationDrawable = relativeLayout.background as AnimationDrawable
        val nextButton = findViewById<Button>(R.id.next_button)
        val intent = Intent(this, SearchActivity::class.java)
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()

        viewPager = findViewById(R.id.pager)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        dotsIndicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                if(position == 3) {
                    nextButton.visibility = View.VISIBLE
                    nextButton.setOnClickListener {

                        startActivity(intent)
                    }

                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        }
        )
    }
}