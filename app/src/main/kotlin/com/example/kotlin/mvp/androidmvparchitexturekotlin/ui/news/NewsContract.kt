package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.news

import android.content.Context
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.entities.ArticleEntity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.base.IBaseView

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

interface NewsContract {

    interface ContractPresenter {

        fun getArticles(context: Context)

        fun getArticlesFromApi()

        fun getArticleFromDb()

        fun saveArticles(items: List<ArticleEntity>)

    }

    interface ContractView : IBaseView {

        fun onArtilesReady(items: List<ArticleEntity>)

    }
}