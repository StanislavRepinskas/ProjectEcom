package com.example.product_api

interface ProductDepsProvider {
    fun provideProductsRepository(): ProductsRepository

    interface Holder {
        fun getProductDepsProvider(): ProductDepsProvider
    }
}