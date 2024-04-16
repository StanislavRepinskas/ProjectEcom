package com.example.catalog.di

import com.example.catalog.presentation.CatalogFragment
import com.example.core.di.NavigationDependencyMap
import com.example.core.di.NavigationDependencyProvider
import com.example.product_api.ProductNavigation
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    dependencies = [NavigationDependencyProvider::class],
    modules = [NavigationModule::class]
)
interface CatalogComponent {

    fun inject(fragment: CatalogFragment)

    @Component.Factory
    interface Factory {
        fun create(
            navigationDependencyProvider: NavigationDependencyProvider
        ): CatalogComponent
    }
}

@Module
interface NavigationModule {

    companion object {
        @Provides
        fun provideProductNavigation(map: NavigationDependencyMap): ProductNavigation {
            return map[ProductNavigation::class.java]!!.get() as ProductNavigation
        }
    }
}