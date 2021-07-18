package com.wency.githubuserapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wency.githubuserapi.data.User
import com.wency.githubuserapi.service.DataSource
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>>
        get() = _userList

    init {
        getUser()
    }

    private fun getUser(){
        viewModelScope.launch {
            val result = DataSource.getUsersInfo()
            if (result == null){
                Log.w("getDataFailed","get user data failed")
            } else {
                _userList.value = result!!
            }
        }
    }
    fun searchUser(query: String){
        viewModelScope.launch {
            val result = DataSource.searchUser(query)
            if (result == null){
                Log.w("getDataFailed","search user data failed")
            } else {
                _userList.value = result!!
            }
        }
    }
}