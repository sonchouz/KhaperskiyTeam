
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeCompiler)
}

android {
    namespace = "com.example.khaperskiyteam"

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.khaperskiyteam"

        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    // Shared module
    implementation(project(":shared"))

    // Activity
    implementation(libs.androidx.activity.compose)

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.ui.tooling.preview)

    // Compose UI
    implementation(libs.compose.runtime)
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    debugImplementation(libs.androidx.ui.tooling)
}
