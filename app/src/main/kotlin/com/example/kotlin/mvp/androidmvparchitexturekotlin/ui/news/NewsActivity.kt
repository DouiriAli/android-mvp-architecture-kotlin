package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.kotlin.mvp.androidmvparchitexturekotlin.NewsApp
import com.example.kotlin.mvp.androidmvparchitexturekotlin.R
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.entities.ArticleEntity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.view_error.*
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

class NewsActivity : BaseActivity(), NewsContract.ContractView, NewsAdapter.OnItemClickListener {

    private final val TAG = NewsActivity::class.java.simpleName

    private var mAdapter: NewsAdapter? = null

    @Inject
    lateinit var mPresenter: NewsPresenter

    init {

        NewsApp.mNewsComponent?.inject(this)

        mPresenter.attachView(this)

        mAdapter = NewsAdapter(this, ArrayList<ArticleEntity>(), this)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_news)

        setUp()

        mPresenter.getArticles(this)

    }

    override fun setUp() {

        val mLayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = mLayoutManager
        recyclerview.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerview.adapter = mAdapter

    }

    override fun onArtilesReady(items: List<ArticleEntity>) {

        if (items != null && !items.isEmpty()) {

            hideErrorContainer()
            mAdapter?.setItems(items)

        } else {

            showErrorContainer()
        }

    }

    override fun onItemClick(item : ArticleEntity) {

        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item?.url)))
    }

    private fun showErrorContainer() {

        content_error.visibility = View.VISIBLE
    }

    private fun hideErrorContainer() {

        content_error.visibility = View.GONE

    }


    override fun onDestroy() {

        mPresenter?.detachView()
        super.onDestroy()
    }

}