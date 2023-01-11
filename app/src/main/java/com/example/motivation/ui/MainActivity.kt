package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Esconde a barra de navegação
        supportActionBar?.hide()

        handleUserName()
        handleNextPhrase()

        binding.btnNewPhrase.setOnClickListener(this)
        binding.icAll.setOnClickListener(this)
        binding.icHappy.setOnClickListener(this)
        binding.icSunny.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view!!.id == R.id.btn_new_phrase){
            handleNextPhrase()
        }

        if(view.id in listOf(R.id.ic_all, R.id.ic_happy, R.id.ic_sunny)){
            handleFilter(view.id)
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        binding.hello.text = "${getString(R.string.hello)}, $name!"
    }

    private fun handleFilter(id: Int){
        binding.icAll.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        binding.icHappy.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        binding.icSunny.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))

        when(id){
            R.id.ic_all -> {
                binding.icAll.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.ic_happy -> {
                binding.icHappy.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.ic_sunny -> {
                binding.icSunny.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleNextPhrase(){
        binding.phrase.setText(Mock().getPhrase(categoryId, Locale.getDefault().language))
    }
}