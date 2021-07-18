package com.wency.githubuserapi.service

import android.util.Log
import com.wency.githubuserapi.data.User

object DataSource {
    suspend fun getUsersInfo(): List<User>? {
        return try {
            val listResult = GitHubApi.retrofitService.getUserList()
            listResult
        } catch (e: Exception) {
            Log.w("DataSource","[${this::class.simpleName}] exception=${e.message}")
            null
        }
    }
    suspend fun searchUser(query: String): List<User>?{
        return try {
            val listResult = GitHubApi.retrofitService.searchUserList(query)
            listResult.users
        } catch (e: Exception) {
            Log.w("DataSource","[${this::class.simpleName}] exception=${e.message}")
            null
        }
    }
}