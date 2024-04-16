package com.example.product_api

import com.example.core.domain.model.Product

interface ProductNavigation {
    fun openProduct(product: Product)
}