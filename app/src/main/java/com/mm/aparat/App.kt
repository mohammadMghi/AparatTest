package com.mm.aparat

import android.app.Application
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import com.mm.aparat.data.repo.VideoRepository
import com.mm.aparat.data.repo.VideoRepositoryImpl
import com.mm.aparat.data.repo.source.VideoRemoteDataSourceImpl
import com.mm.aparat.feature.main.MainViewModel
import com.mm.aparat.feature.main.detail.DetailModelView
import com.mm.aparat.services.http.ApiService
import com.mm.aparat.services.http.createApiServiceInstance
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
const val EXTRA_KEY = "data"
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        val myModule = module {
            single<ApiService> {
                createApiServiceInstance()
            }

            factory<VideoRepository> {
                VideoRepositoryImpl(VideoRemoteDataSourceImpl(get()))
            }

            viewModel { MainViewModel(get()) }
            viewModel { (bundle :Bundle) -> DetailModelView(bundle) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }
    }
}