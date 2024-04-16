package com.example.multimodule

import android.app.Application
import com.example.multimodule.di.DaggerAppComponent

class App : Application() {
    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}