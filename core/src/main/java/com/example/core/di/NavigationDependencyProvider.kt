package com.example.core.di

import javax.inject.Provider

typealias NavigationDependencyMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

interface NavigationDependencyProvider {
    fun provideNavigationMap(): NavigationDependencyMap
}