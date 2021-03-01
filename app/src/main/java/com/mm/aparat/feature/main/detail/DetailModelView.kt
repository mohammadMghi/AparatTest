package com.mm.aparat.feature.main.detail

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mm.aparat.EXTRA_KEY
import com.mm.aparat.data.Mostviewedvideo

class DetailModelView(val bundle: Bundle) : ViewModel() {
    val mostViewedLiveData = MutableLiveData<Mostviewedvideo>()
    init {
        mostViewedLiveData.value = bundle.getParcelable(EXTRA_KEY)
    }
}