package com.example.shoppinglist.domain

class AddShopItemUseCase(private val shopItemListRepository: ShopItemListRepository) {
    fun addShopItem(shopItem: ShopItem) {
        shopItemListRepository.addShopItem(shopItem)
    }
}