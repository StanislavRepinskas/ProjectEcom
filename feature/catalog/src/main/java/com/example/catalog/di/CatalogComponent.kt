package com.example.catalog.di

import com.example.catalog.presentation.CatalogFragment
import com.example.core.di.NavigationDependencyMap
import com.example.core.di.NavigationDepsProvider
import com.example.product_api.ProductNavigation
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    dependencies = [NavigationDepsProvider::class],
    modules = [CatalogModule::class, NavigationModule::class]
)
interface CatalogComponent {

    fun inject(fragment: CatalogFragment)

    @Component.Factory
    interface Factory {
        fun create(
            navigationDepsProvider: NavigationDepsProvider
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