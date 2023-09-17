package com.example.shoppinglist.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItemById(id: Int) : ShopItem
    fun removeShopItemById(id: Int)
    fun getShopItemList(): List<ShopItem>
}