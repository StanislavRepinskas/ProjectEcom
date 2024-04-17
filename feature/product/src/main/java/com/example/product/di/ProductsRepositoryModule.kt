package com.example.product.di

import com.example.product.data.ProductsRepositoryImpl
import com.example.product_api.ProductsRepository
import dagger.Binds
import dagger.Module

@Module
interface ProductsRepositoryModule {

    @Binds
    fun provideCatalogRepository(impl: ProductsRepositoryImpl): ProductsRepository
}