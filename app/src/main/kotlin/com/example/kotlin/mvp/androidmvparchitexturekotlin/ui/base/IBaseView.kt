package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.base

import android.support.annotation.StringRes

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

interface IBaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(errorMessage: String)

    fun showError(@StringRes errorId: Int)
}