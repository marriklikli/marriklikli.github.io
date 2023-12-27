package com.example.pet_booking

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pet_booking.databinding.ActivitySearchBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class SearchActivity : AppCompatActivity() {
   private lateinit var binding: ActivitySearchBinding
    lateinit var adapter: SitterAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
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
        binding.dateButton.setOnClickListener{
            setData()
        }
        binding.moreButton.setOnClickListener{

            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)

        }


    }
    private fun setData() {
        val datePicker = Calendar.getInstance()
        val date = DatePickerDialog.OnDateSetListener{
            view: DatePicker?, year:Int, month: Int, dayofMonth:Int ->
            datePicker[Calendar.YEAR] = year
            datePicker[Calendar.MONTH] = month
            datePicker[Calendar.DAY_OF_MONTH] = dayofMonth
            val dateFormat = "dd-MMMM-yyyy"
            val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
            binding.date.text = simpleDateFormat.format(datePicker.time)
        }
        DatePickerDialog(
            this@SearchActivity, date,
            datePicker[Calendar.YEAR],
            datePicker[Calendar.MONTH],
            datePicker[Calendar.DAY_OF_MONTH]
        ).show()
    }

    private fun initial() {
        recyclerView = binding.listSitter
        adapter = SitterAdapter()
        recyclerView.adapter = adapter
        adapter.setList(mySitter())
    }

    fun mySitter(): ArrayList<SitterModel> {

        val sitterList = ArrayList<SitterModel>()

        val sitter = SitterModel("Какаши Х.",
            "Большой город, в 15 км. от вас" ,
            "Знает как ухаживать за котами и собаками",
            "4.7(69)", "$6.9/день")

        sitterList.add(sitter)

        val sitter2 = SitterModel("Леонардо Д.",
            "Большой город, в 5 км. от вас" ,
            "Знает как ухаживать за котами",
            "4.3(58)", "$4.9/день")
        sitterList.add(sitter2)

        val sitter3 = SitterModel("Сатору Г.",
            "Большой город, в 20 км. от вас" ,
            "Знает как ухаживать за собаками",
            "5(85)", "$5.9/день")
        sitterList.add(sitter3)

        val sitter4 = SitterModel("Уилл С.",
            "Большой город, в 2 км. от вас" ,
            "Знает как ухаживать за попугаями",
            "4.9(8)", "$2.9/день")
        sitterList.add(sitter4)

        return sitterList

    }
    }



