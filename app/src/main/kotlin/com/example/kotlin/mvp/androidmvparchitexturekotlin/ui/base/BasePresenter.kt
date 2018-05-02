package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.base

import io.reactivex.disposables.Disposable


/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

open class BasePresenter<V : IBaseView> : IBasePresenter<V> {

    private var mView: V? = null
    protected var mDisposable : Disposable? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {

        if (mView != null) mView = null

        if(mDisposable != null) mDisposable?.dispose()
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