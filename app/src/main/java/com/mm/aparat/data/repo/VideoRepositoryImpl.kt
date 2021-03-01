package com.mm.aparat.data.repo

import com.mm.aparat.data.Video
import com.mm.aparat.data.repo.source.VideoDataSource
import io.reactivex.Single

class VideoRepositoryImpl(val videoRemoDataSource: VideoDataSource) : VideoRepository {
    override fun getVideos(): Single<Video> = videoRemoDataSource.getVideos()
}