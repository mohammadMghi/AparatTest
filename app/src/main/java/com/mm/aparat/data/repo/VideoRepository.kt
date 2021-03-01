package com.mm.aparat.data.repo

import com.mm.aparat.data.Video
import io.reactivex.Single

interface VideoRepository {
    fun getVideos() : Single<Video>
}