package com.example.cart_api

import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun add(productId: Long)

    suspend fun remove(productId: Long)

    fun getProductCount(productId: Long): Int

    fun getAllProductCount(): List<CartProductCount>

    fun getCartUpdateFlow(): Flow<Long>
}