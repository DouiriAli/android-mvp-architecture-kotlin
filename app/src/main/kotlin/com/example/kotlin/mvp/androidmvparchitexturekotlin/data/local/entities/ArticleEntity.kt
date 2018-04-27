package com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

@Entity(tableName = "article")
data class ArticleEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @Expose
        @SerializedName("publishedAt")
        @ColumnInfo(name = "publishedAt")
        var publishedAt: String? = null,

        @Expose
        @SerializedName("urlToImage")
        @ColumnInfo(name = "urlToImage")
        var urlToImage: String? = null,

        @Expose
        @SerializedName("url")
        @ColumnInfo(name = "url")
        var url: String? = null,

        @Expose
        @SerializedName("description")
        @ColumnInfo(name = "description")
        var description: String? = null,

        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String? = null,

        @Expose
        @SerializedName("author")
        @ColumnInfo(name = "author")
        var author: String? = null
)