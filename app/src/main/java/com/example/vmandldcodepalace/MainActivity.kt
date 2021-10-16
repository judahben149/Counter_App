package com.example.vmandldcodepalace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vmandldcodepalace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: IncrementViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(IncrementViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvNumberValue.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvNumberState.text = it.toString()
        })

        incrementNumber()
        decrementNumber()
    }

    private fun incrementNumber() {
        binding.btnIncrement.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = if (viewModel.number % 2 == 0) "Even" else "Odd"
        }
    }

    private fun decrementNumber() {
        binding.btnDecrement.setOnClickListener {
            viewModel.currentNumber.value = --viewModel.number
            viewModel.currentBoolean.value = if (viewModel.number % 2 == 0) "Even" else "Odd"
        }
    }
}