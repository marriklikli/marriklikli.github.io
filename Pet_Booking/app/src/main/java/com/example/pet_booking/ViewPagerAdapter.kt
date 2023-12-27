package com.example.pet_booking

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView


class ViewPagerAdapter(val context: Context): PagerAdapter() {
     var layoutInflater: LayoutInflater? = null
     val imgArray = arrayOf(
         R.raw.animationwelcome,
         R.raw.animationsecond,
         R.raw.animationthree,
         R.raw.animationdog,
         R.raw.animationpopug
     )

     val headArray = arrayOf(
         "Pet_Booking",
         "Удобный поиск",
        "Всегда в наличии",
         "Добро пожаловать"
     )

     val arrayDescription = arrayOf(
        "Здесь вы можете найти кого-то, кто с радостью присмотрит за вашим питомцем, пока вас не будет дома",
         "Настройте поисковый фильтр так, как вам нужно, и найдите няню, которая идеально подойдет вам и вашему питомцу",
         "Заключайте контракт с няней в любое время и получайте обновления о своем питомце в чате и ленте историй",
         "Зарегистрируйтесь и заведите карточку домашнего животного, чтобы начать поиск идеальной няни"
     )
     override fun getCount(): Int {
         return headArray.size
     }

     override fun isViewFromObject(view: View, `object`: Any): Boolean {
         return view == `object` as RelativeLayout
     }

     override fun instantiateItem(container: ViewGroup, position: Int): Any {

         layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         val view = layoutInflater!!.inflate(R.layout.slider, container, false)

         val img = view.findViewById<LottieAnimationView>(R.id.profile_image)
         val textHead = view.findViewById<TextView>(R.id.headName)
         val textDescription = view.findViewById<TextView>(R.id.description)

         img.setAnimation(imgArray[position])
         textHead.text = headArray[position]
         textDescription.text = arrayDescription[position]

         container.addView(view)

         return view
     }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
 }