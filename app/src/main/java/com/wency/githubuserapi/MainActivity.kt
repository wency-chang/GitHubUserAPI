package com.wency.githubuserapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.wency.githubuserapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.userRecycler.adapter = UserAdapter()
        binding.searchBar.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN){
                val query = binding.searchBar.text
                if (query.isNotEmpty()){
                    viewModel.searchUser(query = query.toString())
                }
                return@setOnKeyListener true
            } else {
                return@setOnKeyListener false
            }
        }
    }
}