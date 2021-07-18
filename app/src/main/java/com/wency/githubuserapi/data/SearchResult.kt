package com.wency.githubuserapi.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult(
    @Json(name = "total_count")val total: Int,
    @Json(name = "incomplete_results") val result: Boolean,
    @Json(name = "items")val users: List<User>
):Parcelable
