package com.mm.aparat.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ui(
    val pagingBack: String,
    val pagingForward: String
): Parcelable