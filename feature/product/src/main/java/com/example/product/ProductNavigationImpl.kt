package com.example.product

import android.content.Context
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.example.core.di.ApplicationContext
import com.example.product_api.ProductNavigation
import javax.inject.Inject

class ProductNavigationImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val navController: NavController
) :
    ProductNavigation {
    override fun openProduct() {
        val navigationUri = context.getString(R.string.productFragmentUri)
        val request = NavDeepLinkRequest.Builder
            .fromUri(navigationUri.toUri())
            .build()
        navController.navigate(request)
    }
}