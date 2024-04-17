package com.example.product_api

import androidx.navigation.NavController

interface ProductNavigation {
    fun openProduct(navController: NavController, product: Product)
}