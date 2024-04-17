package com.example.product_api

interface ProductsRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProducts(ids: List<Long>): List<Product>
}