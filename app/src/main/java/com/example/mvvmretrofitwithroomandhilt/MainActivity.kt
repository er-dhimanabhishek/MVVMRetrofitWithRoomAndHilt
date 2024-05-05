package com.example.mvvmretrofitwithroomandhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitwithroomandhilt.databinding.ActivityMainBinding
import com.example.mvvmretrofitwithroomandhilt.model.Response
import com.example.mvvmretrofitwithroomandhilt.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.productsLiveData.observe(this){
            when (it){
                is Response.Error ->{
                    hideLoading()
                    _binding.tvProductTitle.text = it.errorMsg
                }
                is Response.Loading -> {
                    showLoading()
                }
                is Response.Success -> {
                    hideLoading()
                    it.let {
                        _binding.tvProductTitle.text = it.productList?.get(0)?.title
                    }
                }
            }
        }

    }

    private fun showLoading() {
        _binding.progressBar.visibility = View.VISIBLE
        _binding.tvProductTitle.visibility = View.GONE
    }
    private fun hideLoading(){
        _binding.progressBar.visibility = View.GONE
        _binding.tvProductTitle.visibility = View.VISIBLE
    }
}