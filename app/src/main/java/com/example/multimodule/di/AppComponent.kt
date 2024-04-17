package com.example.multimodule.di

import android.content.Context
import com.example.cart.di.CartRepositoryModule
import com.example.cart_api.CartDepsProvider
import com.example.core.di.ApplicationContext
import com.example.core.di.ApplicationScope
import com.example.core.di.NavigationDepsProvider
import com.example.product.di.ProductsRepositoryModule
import com.example.product_api.ProductDepsProvider
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        NavigationModule::class,
        CartRepositoryModule::class,
        ProductsRepositoryModule::class
    ]
)
interface AppComponent :
    NavigationDepsProvider,
    CartDepsProvider,
    ProductDepsProvider {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context
}