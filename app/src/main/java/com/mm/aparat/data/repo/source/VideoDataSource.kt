package com.mm.aparat.data.repo.source

import com.mm.aparat.data.Video
import io.reactivex.Single

interface VideoDataSource {
    fun getVideos() : Single<Video>
}