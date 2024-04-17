package com.example.cart_api

import com.example.core.di.NavigationDepsMap

interface CartDepsProvider {
    fun provideCartRepository(): CartRepository

    interface Holder {
        fun getCartDepsProvider(): CartDepsProvider
    }
}