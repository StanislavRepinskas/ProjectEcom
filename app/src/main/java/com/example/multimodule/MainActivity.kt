package com.example.multimodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.core.di.NavigationDependencyHolder
import com.example.core.di.NavigationDependencyProvider
import com.example.multimodule.di.DaggerActivityComponent
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), NavigationDependencyHolder {
    private val component by lazy {
        DaggerActivityComponent.factory().create(
            appComponent = (application as App).component,
            nacController = findNavController(R.id.navHostFragment)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController: NavController = findNavController(R.id.navHostFragment)
        val navGraph = navController.navInflater.inflate(R.navigation.graph)
        navController.graph = navGraph

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setupWithNavController(navController)
    }

    override fun getNavigationDependencyProvider(): NavigationDependencyProvider {
        return component
    }
}