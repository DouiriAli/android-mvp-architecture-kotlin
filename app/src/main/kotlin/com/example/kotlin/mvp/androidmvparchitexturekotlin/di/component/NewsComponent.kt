package com.example.kotlin.mvp.androidmvparchitexturekotlin.di

import androidachitecturecomponent.example.di.AppComponent
import com.example.kotlin.mvp.androidmvparchitexturekotlin.di.scope.NewsScope
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.news.NewsActivity
import dagger.Component

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

@NewsScope
@Component(modules = arrayOf(NewsModule::class), dependencies = arrayOf(AppComponent::class))
interface NewsComponent {

    fun inject(view: NewsActivity)
}