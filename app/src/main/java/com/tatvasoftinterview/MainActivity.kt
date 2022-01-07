package com.tatvasoftinterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatvasoftinterview.adapter.UserAdapter
import com.tatvasoftinterview.model.UserItem
import com.tatvasoftinterview.viewmodel.UserItemViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var userListRecyclerView: RecyclerView
    private var userList = arrayListOf<UserItem>()
    private lateinit var userItemViewModel: UserItemViewModel
    private var userAdapter = UserAdapter()
    var loading = false
    var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        userItemViewModel = ViewModelProviders.of(this)[UserItemViewModel::class.java]
        userAdapter.context = this

        userItemViewModel.getUserItems().observe(this, {
            if (it != null) {
                for (i in it.data.userItemParams.indices) {
                    userList.add(it.data.userItemParams[i])
                }
                userAdapter.userList = userList
                userListRecyclerView.adapter = userAdapter
                userAdapter.notifyDataSetChanged()
            }
        })
        userItemViewModel.fetchUserItems(page)

        userListRecyclerView
            .addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(
                    recyclerView: RecyclerView, dx: Int,
                    dy: Int
                ) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0) {
                        val mLinearLayoutManager = userListRecyclerView
                            .layoutManager as LinearLayoutManager
                        val visibleItemCount = recyclerView.childCount
                        val totalItemCount = mLinearLayoutManager
                            .itemCount
                        val firstVisibleItem = mLinearLayoutManager
                            .findFirstVisibleItemPosition()
                        if (loading) {
                            var previousTotal = mLinearLayoutManager.itemCount
                            if (totalItemCount > previousTotal) {
                                previousTotal = totalItemCount
                                page++
                            }
                        }
                        if (!loading
                            && firstVisibleItem + 1 + visibleItemCount >= totalItemCount
                        ) {
                            page++
                            getPagination()
                        }
                    }
                }
            })

    }

    private fun getPagination() {
        userItemViewModel.getUserItems().observe(this, {
            if (it != null) {
                for (i in it.data.userItemParams.indices) {
                    userList.add(it.data.userItemParams[i])
                }
                userAdapter.userList = userList
                userListRecyclerView.adapter = userAdapter
                userAdapter.notifyDataSetChanged()
            }
        })
        userItemViewModel.fetchUserItems(page)
    }

    private fun initializeViews() {
        userListRecyclerView = findViewById(R.id.user_list)
    }
}