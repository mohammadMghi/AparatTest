package com.mm.aparat.data.repo.source

import com.mm.aparat.data.Video
import com.mm.aparat.services.http.ApiService
import io.reactivex.Single

class VideoRemoteDataSourceImpl(val apiService: ApiService) : VideoDataSource {
    override fun getVideos(): Single<Video> = apiService.getMostViewedVideos()
}