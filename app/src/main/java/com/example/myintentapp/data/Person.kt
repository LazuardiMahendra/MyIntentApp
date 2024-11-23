package com.example.myintentapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name : String?,
    val age : Int?,
    val city : String?
) : Parcelable
