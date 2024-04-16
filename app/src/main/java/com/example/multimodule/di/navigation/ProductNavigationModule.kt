package com.example.multimodule.di.navigation

import com.example.multimodule.navigation.ProductNavigationImpl
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