package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemListRepository
import kotlin.random.Random

class ShopItemListRepositoryImpl : ShopItemListRepository {

    private val shopItemsLD = MutableLiveData<List<ShopItem>>()
    private val shopItems = sortedSetOf<ShopItem>({ i1, i2 -> i1.id.compareTo(i2.id) })
    private var autoIncrementId = 0


    init {
        for (i in 0 until 100) {
            val shopItem = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(shopItem)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopItems.add(shopItem)
        updateShopListLD()
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
        updateShopListLD()
    }

    override fun getShopItemList(): LiveData<List<ShopItem>> {
        return shopItemsLD
    }

    private fun updateShopListLD() {
        shopItemsLD.value = shopItems.toList()
    }
}