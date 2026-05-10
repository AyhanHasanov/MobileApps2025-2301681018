plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)                      // annotation processor for Room + Hilt
    alias(libs.plugins.hilt)                     // Hilt DI plugin
    alias(libs.plugins.navigation.safeargs)
}

android {
    namespace = "com.example.mobileapps2025_2301681018"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mobileapps2025_2301681018"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val apiKey = project.findProperty("MAPS_API_KEY")?.toString() ?: ""
        manifestPlaceholders["MAPS_API_KEY"] = apiKey
        buildConfigField("String", "MAPS_API_KEY", "\"$apiKey\"")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true   // type-safe layout access, no findViewById
        buildConfig = true   // allows BuildConfig.MAPS_API_KEY
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.kotlinx.coroutines.android)

    // ── Lifecycle / ViewModel ─────────────────────
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // ── Navigation ────────────────────────────────
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    // ── Room ──────────────────────────────────────
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)           // annotation processor

    // ── Hilt ──────────────────────────────────────
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)   // annotation processor

    // ── DataStore ─────────────────────────────────
    implementation(libs.datastore.preferences)

    // ── Maps & Places ─────────────────────────────
    implementation(libs.play.services.maps)
    implementation(libs.places)
}