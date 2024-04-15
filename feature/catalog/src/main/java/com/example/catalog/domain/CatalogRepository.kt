package com.example.catalog.domain

import com.example.core.domain.model.Product

interface CatalogRepository {
    suspend fun getProducts(): List<Product>
}