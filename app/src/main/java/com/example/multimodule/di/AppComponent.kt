package com.example.multimodule.di

import android.content.Context
import com.example.core.di.ApplicationContext
import com.example.core.di.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context
}