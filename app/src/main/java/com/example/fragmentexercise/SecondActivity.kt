package com.example.fragmentexercise

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentexercise.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    @SuppressLint("CommitTransaction", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var buttonStatus = false
        val dynamicFragment = FragmentExample1()

        binding.buttonPreviousPart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.buttonFragment.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransition = fragmentManager.beginTransaction()
            if(!buttonStatus){
                buttonStatus = true
                fragmentTransition.add(R.id.fragmentExample2, dynamicFragment).commit()
                binding.buttonFragment.text = "CLOSE"
            } else {
                buttonStatus = false
                fragmentTransition.remove(dynamicFragment).commit()
                binding.buttonFragment.text = "OPEN"
            }
        }
    }
}