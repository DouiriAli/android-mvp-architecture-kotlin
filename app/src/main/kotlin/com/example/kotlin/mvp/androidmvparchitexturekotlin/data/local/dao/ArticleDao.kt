package com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.entities.ArticleEntity
import io.reactivex.Flowable

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getArticlesFromDb() : Flowable<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveArticles(users : List<ArticleEntity>)

    @Query("DELETE FROM article")
    fun deleteArticles()

}