package com.example.product.di

import com.example.product.ProductNavigationImpl
import com.example.product_api.ProductNavigation
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ProductNavigationModule {
    @Binds
    @IntoMap
    @ClassKey(ProductNavigation::class)
    fun provideProductNavigation(impl: ProductNavigationImpl): Any
}