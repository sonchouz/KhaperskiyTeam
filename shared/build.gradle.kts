
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {

    // iOS
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    // Android
    android {
        namespace = "com.example.khaperskiyteam.shared"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }

        androidResources {
            enable = true
        }
    }

    sourceSets {

        // Общий код для Android и iOS
        commonMain.dependencies {

            // Compose
            // Compose
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.material.icons.extended)

            // Lifecycle
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Navigation
            implementation(libs.androidx.navigation.compose)

            // Supabase
            implementation(libs.supabase.auth)
            implementation(libs.supabase.postgrest)
            implementation(libs.supabase.storage)

            // Ktor
            implementation(libs.ktor.client.core)

            // Serialization
            implementation(libs.kotlinx.serialization.json)
        }

        // Android
        androidMain.dependencies {

            implementation(libs.ktor.client.okhttp)
            implementation(libs.coil.compose)
        }

        // iOS
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        // Tests
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

// Compose Preview
dependencies {
    androidRuntimeClasspath(libs.compose.ui.tooling)
}
