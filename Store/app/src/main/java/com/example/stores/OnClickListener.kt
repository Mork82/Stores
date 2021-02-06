package com.example.stores

interface OnClickListener {
    fun onClick(storeEntity: StoreEntity)
    fun onFavoriteStar(storeEntity: StoreEntity)
    fun onDeleteStore(storeEntity: StoreEntity)
}