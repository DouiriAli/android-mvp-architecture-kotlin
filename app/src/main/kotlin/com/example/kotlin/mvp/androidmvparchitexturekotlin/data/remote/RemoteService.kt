package com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote

import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.model.News
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

interface RemoteService {

    @GET(".")
    fun getArticlesFromApi() : Flowable<Response<News>>
}