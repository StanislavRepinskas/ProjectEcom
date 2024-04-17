package com.example.cart.di

import com.example.cart.data.CartRepositoryImpl
import com.example.cart_api.CartRepository
import com.example.core.di.ApplicationScope
import dagger.Binds
import dagger.Module

@Module
interface CartRepositoryModule {
    @ApplicationScope
    @Binds
    fun provideCartRepository(impl: CartRepositoryImpl): CartRepository
}