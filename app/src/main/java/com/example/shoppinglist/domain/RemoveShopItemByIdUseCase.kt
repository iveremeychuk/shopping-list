package com.example.shoppinglist.domain

class RemoveShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {
    fun removeShopItemById(id: Int) {
        shopListRepository.removeShopItemById(id)
    }
}