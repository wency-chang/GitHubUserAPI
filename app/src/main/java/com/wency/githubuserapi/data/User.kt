package com.wency.githubuserapi.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    @Json(name = "avatar_url")val profile: String,
    @Json(name = "login")val name: String,
    val url: String
) : Parcelable
