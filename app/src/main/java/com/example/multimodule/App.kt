package com.example.multimodule

import android.app.Application
import com.example.cart_api.CartDepsProvider
import com.example.core.di.NavigationDepsProvider
import com.example.multimodule.di.DaggerAppComponent
import com.example.product_api.ProductDepsProvider

class App : Application(),
    NavigationDepsProvider.Holder,
    CartDepsProvider.Holder,
    ProductDepsProvider.Holder {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun getNavigationDepsProvider() = component
    override fun getCartDepsProvider() = component
    override fun getProductDepsProvider(): ProductDepsProvider = component
}