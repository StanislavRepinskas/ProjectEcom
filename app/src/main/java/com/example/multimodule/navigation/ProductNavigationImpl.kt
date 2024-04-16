package com.example.multimodule.navigation

import androidx.navigation.NavController
import com.example.core.domain.model.Product
import com.example.multimodule.R
import com.example.product.ProductFragment
import com.example.product_api.ProductNavigation
import javax.inject.Inject

class ProductNavigationImpl @Inject constructor(
    private val navController: NavController
) : ProductNavigation {
    override fun openProduct(product: Product) {
        navController.navigate(R.id.openProductFragment, ProductFragment.createArgs(product))
    }
}