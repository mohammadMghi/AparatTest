package com.mm.aparat.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mm.aparat.EXTRA_KEY
import com.mm.aparat.R
import com.mm.aparat.common.AparatActivity
import com.mm.aparat.data.Mostviewedvideo
import com.mm.aparat.data.Video
import com.mm.aparat.feature.main.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AparatActivity() , VideoAdapter.OnVideoClickListener{
    val mainViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoAdapter = VideoAdapter()
        val recVideos = findViewById<RecyclerView>(R.id.recVideos)

        mainViewModel.videoLiveData.observe(this){
            Log.i("MainActivity", "onCreate: $it")
            videoAdapter.mostviewedvideo = it.mostviewedvideos as ArrayList<Mostviewedvideo>
            recVideos.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            recVideos.adapter =videoAdapter
        }
        videoAdapter.onVideoClickListener= this
        mainViewModel.progressBar.observe(this){
            setProgressIndicator(it)
        }
    }

    override fun onVideoClick(mostviewedvideo: Mostviewedvideo) {
        startActivity(Intent(this,DetailActivity::class.java).apply {
            putExtra(EXTRA_KEY,mostviewedvideo)
        })
    }


}