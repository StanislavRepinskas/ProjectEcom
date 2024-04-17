package com.example.product.data

import com.example.product_api.ProductsRepository
import com.example.product_api.Product
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor() : ProductsRepository {
    override suspend fun getProducts(): List<Product> {
        return getMockProducts()
    }

    override suspend fun getProducts(ids: List<Long>): List<Product> {
        return getMockProducts().filter {
            ids.contains(it.id)
        }
    }

    companion object {
        private fun getMockProducts(): List<Product> {
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
}