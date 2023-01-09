package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)
        supportActionBar?.hide()

        verifyUserName()
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_save){
            handleSave()
        }
    }

    private fun handleSave(){
        val name = binding.edtName.text.toString()
        if(name == ""){
            Toast.makeText(
                this,
                R.string.validation_mandatory_name,
                Toast.LENGTH_LONG
            ).show()
            return
        }

        SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun verifyUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        if(name.isNotEmpty()){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}