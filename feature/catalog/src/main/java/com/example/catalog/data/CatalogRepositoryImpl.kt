package com.example.catalog.data

import com.example.catalog.domain.CatalogRepository
import com.example.core.domain.model.Product

class CatalogRepositoryImpl : CatalogRepository {
    override suspend fun getProducts(): List<Product> {
        var productId = 1L
        return listOf(
            Product(
                id = productId++,
                name = "Бананы",
                image = "",
                price = 100
            ),
            Product(
                id = productId++,
                name = "Апельсины",
                image = "",
                price = 150
            ),
            Product(
                id = productId++,
                name = "Яблоки",
                image = "",
                price = 90
            ),
            Product(
                id = productId++,
                name = "Груши",
                image = "",
                price = 135
            ),
            Product(
                id = productId,
                name = "Манго",
                image = "",
                price = 300
            )
        )
    }
}