package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.news

import android.content.Context
import android.os.AsyncTask
import android.support.annotation.NonNull
import android.util.Log
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.LocalDataSource
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.entities.ArticleEntity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.RemoteDataSource
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.base.BasePresenter
import com.example.kotlin.mvp.androidmvparchitexturekotlin.utils.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rx.Completable
import rx.CompletableSubscriber
import rx.Subscription

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

class NewsPresenter(val mLocalDataSource: LocalDataSource, val mRemoteDataSource: RemoteDataSource) : BasePresenter<NewsContract.ContractView>(), NewsContract.ContractPresenter {

    private final val TAG = NewsPresenter::class.java.simpleName

    override fun getArticles(context: Context) {

        if (NetworkUtil.isNetworkConnected(context))
            getArticlesFromApi()
        else
            getArticleFromDb()
    }

    override fun getArticlesFromApi() {

        getView()?.showLoading()

        mDisposable = mRemoteDataSource.getAriclesFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    if (!isViewAttached()) return@subscribe

                    getView()?.hideLoading()

                    if (response.isSuccessful) {
                        saveArticles(response.body()?.mArticles!!)
                        getView()?.onArtilesReady(response.body()?.mArticles!!)
                    }

                },
                        { error ->
                            getView()?.hideLoading();Log.e(TAG, "{$error.message}")
                        },
                        {
                            getView()?.hideLoading()
                            Log.d(TAG, "completed")
                        })

    }

    override fun getArticleFromDb() {

        getView()?.showLoading()

        mLocalDataSource.getArticleDao().getArticlesFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    if (!isViewAttached()) return@subscribe

                    getView()?.hideLoading()

                    getView()?.onArtilesReady(response)

                },
                        { error ->
                            getView()?.hideLoading();Log.e(TAG, "{$error.message}")
                        },
                        {
                            getView()?.hideLoading()
                            Log.d(TAG, "completed")
                        })

    }

    override fun saveArticles(items: List<ArticleEntity>) {

        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void): Void? {
                mLocalDataSource.getArticleDao().deleteArticles()
                mLocalDataSource.getArticleDao().saveArticles(items)
                return null
            }
        }.execute()

    }
}