package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Crew(
    val name: String,
    val description: String,
    val power: String,
    val weak: String,
    val photo: Int,
    val photobg: Int
): Parcelable
