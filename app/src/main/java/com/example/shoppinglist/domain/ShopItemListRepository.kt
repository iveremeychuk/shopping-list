package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopItemListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItemById(id: Int) : ShopItem
    fun removeShopItemById(id: Int)
    fun getShopItemList(): LiveData<List<ShopItem>>
}