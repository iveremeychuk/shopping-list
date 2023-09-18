package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopItemListRepositoryImpl
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopItemListUseCase
import com.example.shoppinglist.domain.RemoveShopItemByIdUseCase
import com.example.shoppinglist.domain.ShopItem

class ShopItemListViewModel : ViewModel() {

    private val repository = ShopItemListRepositoryImpl()

    private val getShopItemListUseCase = GetShopItemListUseCase(repository)
    private val removeShopItemByIdUseCase = RemoveShopItemByIdUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopItemList = getShopItemListUseCase.getShopItemList()
    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemByIdUseCase.removeShopItemById(shopItem.id)
    }

    fun changeShopItemIsActiveField(shopItem: ShopItem) {
        var newItem = shopItem.copy(isActive = !shopItem.isActive)
        editShopItemUseCase.editShopItem(newItem)
    }
}