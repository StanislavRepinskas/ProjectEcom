package com.example.core.di

import javax.inject.Provider

typealias NavigationDepsMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

interface NavigationDepsProvider {
    fun provideNavigationMap(): NavigationDepsMap

    interface Holder {
        fun getNavigationDepsProvider(): NavigationDepsProvider
    }
}