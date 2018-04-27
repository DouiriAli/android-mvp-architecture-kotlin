package com.example.kotlin.mvp.androidmvparchitexturekotlin.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

object NetworkUtil {

    fun isNetworkConnected(context: Context): Boolean {

        val mConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val mActiveNetwork = mConnectivityManager.activeNetworkInfo
        return mActiveNetwork != null && mActiveNetwork.isConnectedOrConnecting

    }

}