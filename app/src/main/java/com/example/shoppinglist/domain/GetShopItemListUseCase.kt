package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopItemListUseCase(private val shopItemListRepository: ShopItemListRepository) {
    fun getShopItemList(): LiveData<List<ShopItem>> {
        return shopItemListRepository.getShopItemList()
    }
}