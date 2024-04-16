package com.example.core.di

import javax.inject.Provider

typealias NavigationDependencyMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

interface NavigationDepsProvider {
    fun provideNavigationMap(): NavigationDependencyMap

    interface Holder {
        fun getNavigationDepsProvider(): NavigationDepsProvider
    }
}