package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.base

import rx.Subscription

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

open class BasePresenter<V : IBaseView> : IBasePresenter<V> {

    private var mView: V? = null
    private val mSubscription: Subscription? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {

        if (mView != null)
            mView = null

        if (mSubscription!!.isUnsubscribed)
            mSubscription?.unsubscribe()
    }

    override fun isViewAttached(): Boolean {
        return mView != null
    }

    fun getView(): V? {
        return mView
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }


    class ViewNotAttachedException : RuntimeException("Please call Presenter.attachView(view) before" + " requesting data to the Presenter")
}