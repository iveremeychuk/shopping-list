package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopItems = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopItems.add(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        removeShopItemById(shopItem.id)
        addShopItem(shopItem)
    }

    override fun getShopItemById(id: Int): ShopItem {
        return shopItems.find {
            it.id == id
        } ?: throw RuntimeException("Element with id = $id not found")
    }

    override fun removeShopItemById(id: Int) {
        shopItems.remove(getShopItemById(id))
    }

    override fun getShopItemList(): List<ShopItem> {
        return shopItems.toList()
    }

}