package com.example.shoppinglist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var shopItemListViewModel: ShopItemListViewModel
    private lateinit var adapter: ShopItemListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        shopItemListViewModel = ViewModelProvider(this)[ShopItemListViewModel::class.java]
        shopItemListViewModel.shopItemList.observe(this) {
            adapter.shopItemList = it
        }
    }

    private fun setupRecyclerView() {
        var shopItemListRv = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopItemListAdapter()
        shopItemListRv.adapter = adapter
        shopItemListRv.recycledViewPool.setMaxRecycledViews(ITEM_SHOP_ENABLED_VIEW_TYPE, MAX_VIEW_HOLDER_POOL_SIZE)
        shopItemListRv.recycledViewPool.setMaxRecycledViews(ITEM_SHOP_DISABLED_VIEW_TYPE, MAX_VIEW_HOLDER_POOL_SIZE)
    }
}