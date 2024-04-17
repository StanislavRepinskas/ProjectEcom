package com.example.multimodule.navigation

import androidx.navigation.NavController
import com.example.product_api.Product
import com.example.multimodule.R
import com.example.product.presentation.ProductFragment
import com.example.product_api.ProductNavigation
import javax.inject.Inject

class ProductNavigationImpl @Inject constructor() : ProductNavigation {
    override fun openProduct(navController: NavController, product: Product) {
        navController.navigate(R.id.openProductFragment, ProductFragment.createArgs(product))
    }
}