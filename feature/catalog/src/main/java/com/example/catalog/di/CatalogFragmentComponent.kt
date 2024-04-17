package com.example.catalog.di

import com.example.cart_api.CartDepsProvider
import com.example.catalog.presentation.CatalogFragment
import com.example.core.di.NavigationDepsMap
import com.example.core.di.NavigationDepsProvider
import com.example.product_api.ProductDepsProvider
import com.example.product_api.ProductNavigation
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    dependencies = [
        NavigationDepsProvider::class,
        CartDepsProvider::class,
        ProductDepsProvider::class
    ],
    modules = [NavigationModule::class]
)
interface CatalogFragmentComponent {

    fun inject(fragment: CatalogFragment)

    @Component.Factory
    interface Factory {
        fun create(
            navigationDepsProvider: NavigationDepsProvider,
            productDepsProvider: ProductDepsProvider,
            cartDepsProvider: CartDepsProvider
        ): CatalogFragmentComponent
    }
}

@Module
interface NavigationModule {

    companion object {
        @Provides
        fun provideProductNavigation(map: NavigationDepsMap): ProductNavigation {
            return map[ProductNavigation::class.java]!!.get() as ProductNavigation
        }
    }
}