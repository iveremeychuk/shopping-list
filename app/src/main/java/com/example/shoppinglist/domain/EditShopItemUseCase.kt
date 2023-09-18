package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopItemListRepository: ShopItemListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        shopItemListRepository.editShopItem(shopItem)
    }
}