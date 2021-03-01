package com.mm.aparat.feature.main.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mm.aparat.R
import com.mm.aparat.feature.main.MainViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.lang.reflect.Parameter

class DetailActivity : AppCompatActivity() {
    val detailModelView : DetailModelView by viewModel { parametersOf(intent.extras) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailModelView.mostViewedLiveData.observe(this){
            Log.e("DetailActivity", "onCreate: $it")
            webView.settings.javaScriptEnabled = true
            webView.loadUrl("https://www.aparat.com/video/video/embed/videohash/NUHdS/vt/frame")
        }

    }
}