package com.mm.aparat.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mm.aparat.data.Video
import com.mm.aparat.data.repo.VideoRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val videoRepository: VideoRepository) : ViewModel() {
    val compositeDisposable : CompositeDisposable? = null
    val videoLiveData = MutableLiveData<Video>()
    val progressBar = MutableLiveData<Boolean>()
    init {
        progressBar.value = true
        videoRepository.getVideos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally{
                progressBar.value = false
            }
            .subscribe(object : SingleObserver<Video> {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable?.add(d)
                }

                override fun onSuccess(t: Video) {
                    videoLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }


            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.clear()
    }
}