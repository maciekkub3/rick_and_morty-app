plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.rickandmorty"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rickandmorty"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.base)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.navigation.compose)


    //hilt
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.google.hilt)
    kapt(libs.google.hilt.compiler)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation (libs.okhttp)

    //coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    implementation(libs.moshi.kotlin)
    implementation(libs.moshi)
    implementation(libs.converter.moshi)

    implementation(libs.logging.interceptor)
    implementation(libs.coil.compose)

    implementation(libs.kotlinx.serialization.json)



}