package com.wency.githubuserapi.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wency.githubuserapi.data.SearchResult
import com.wency.githubuserapi.data.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.github.com/"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

interface GithubService {
    @GET("users")
    suspend fun getUserList(): List<User>

    @GET("search/users")
    suspend fun searchUserList(@Query("q") query: String): SearchResult
}

object GitHubApi {
    val retrofitService : GithubService by lazy { retrofit.create(GithubService::class.java) }
}