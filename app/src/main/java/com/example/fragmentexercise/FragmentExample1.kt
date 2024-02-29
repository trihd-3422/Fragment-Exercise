package com.example.fragmentexercise

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentexercise.databinding.FragmentExample1Binding


class FragmentExample1 : Fragment() {
    private val binding by lazy {FragmentExample1Binding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioButtonYes.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.textView.text = "ARTICLE: Like"
                binding.radioButtonNo.isChecked = false
            }
        }
        binding.radioButtonNo.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.textView.text = "ARTICLE: Thanks"
                binding.radioButtonYes.isChecked = false
            }
        }
    }
}