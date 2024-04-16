pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiModule"
include(":app")
include(":core")
include("feature:cart")
include("feature:cart-api")
include("feature:product")
include("feature:product-api")
include("feature:catalog")
include("feature:profile")

