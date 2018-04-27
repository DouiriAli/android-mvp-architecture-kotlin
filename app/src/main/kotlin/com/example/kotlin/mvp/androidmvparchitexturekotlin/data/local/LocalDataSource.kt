package com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.dao.ArticleDao
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.entities.ArticleEntity
import javax.inject.Singleton

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

@Singleton
@Database(entities = arrayOf(ArticleEntity::class), version = 1)
abstract class LocalDataSource : RoomDatabase() {

    abstract fun getArticleDao() : ArticleDao
}