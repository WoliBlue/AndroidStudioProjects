plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.listviewpractica"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.listviewpractica"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation("androidx.core:core-splashscreen:1.0.0")
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.25")
    androidTestImplementation(libs.espresso.core)

}
