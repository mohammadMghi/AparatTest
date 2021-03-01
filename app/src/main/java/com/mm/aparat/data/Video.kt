package com.mm.aparat.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(
    val mostviewedvideos: List<Mostviewedvideo>,
    val ui: Ui
) : Parcelable