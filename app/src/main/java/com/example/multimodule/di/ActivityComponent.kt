package com.example.multimodule.di

import androidx.navigation.NavController
import com.example.core.di.ActivityScope
import com.example.core.di.NavigationDepsProvider
import com.example.multimodule.di.navigation.ProductNavigationModule
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ProductNavigationModule::class]
)
interface ActivityComponent : NavigationDepsProvider {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance
            nacController: NavController
        ): ActivityComponent
    }
}