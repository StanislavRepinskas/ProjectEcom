package com.example.multimodule.di

import com.example.core.di.ActivityScope
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class]
)
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent
        ): ActivityComponent
    }
}