package com.example.shoppinglist.domain

class RemoveShopItemByIdUseCase(private val shopItemListRepository: ShopItemListRepository) {
    fun removeShopItemById(id: Int) {
        shopItemListRepository.removeShopItemById(id)
    }
}