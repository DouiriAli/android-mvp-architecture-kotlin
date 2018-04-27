package com.example.kotlin.mvp.androidmvparchitexturekotlin.di

import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.LocalDataSource
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.RemoteDataSource
import com.example.kotlin.mvp.androidmvparchitexturekotlin.di.scope.NewsScope
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.news.NewsPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

@Module
class NewsModule {

    @Provides
    @NewsScope
    fun providesNewsPresenter(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): NewsPresenter =
            NewsPresenter(localDataSource, remoteDataSource)
}