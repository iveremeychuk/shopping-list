package com.example.shoppinglist.domain

class GetShopItemByIdUseCase(private val shopItemListRepository: ShopItemListRepository) {
    fun getShopItemById(id: Int) : ShopItem {
        return shopItemListRepository.getShopItemById(id)
    }
}