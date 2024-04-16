package com.example.catalog.di

import com.example.catalog.data.CatalogRepositoryImpl
import com.example.catalog.domain.CatalogRepository
import dagger.Binds
import dagger.Module

@Module
interface CatalogModule {

    @Binds
    fun provideCatalogRepository(impl: CatalogRepositoryImpl): CatalogRepository
}