package com.example.shoppinglist.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem


const val ITEM_SHOP_ENABLED_VIEW_TYPE = 0
const val ITEM_SHOP_DISABLED_VIEW_TYPE = 1
const val MAX_VIEW_HOLDER_POOL_SIZE = 15

class ShopItemListAdapter : RecyclerView.Adapter<ShopItemListAdapter.ShopItemViewHolder>() {

    var shopItemList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var count = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("onCreateViewHolder", "${++count}")
        val layout = when (viewType) {
            ITEM_SHOP_ENABLED_VIEW_TYPE -> R.layout.item_shop_enabled
            ITEM_SHOP_DISABLED_VIEW_TYPE -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopItemList.size
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = shopItemList[position]
        holder.nameTextView.text = shopItem.name
        holder.countTextView.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopItemList[position]

        return if (item.isActive) ITEM_SHOP_ENABLED_VIEW_TYPE else ITEM_SHOP_DISABLED_VIEW_TYPE
    }

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById<TextView>(R.id.tv_name)
        val countTextView = view.findViewById<TextView>(R.id.tv_count)
    }
}