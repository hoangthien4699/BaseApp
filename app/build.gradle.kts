plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.retails"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retails"
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

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    implementation ("org.greenrobot:eventbus:3.3.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.9.0")
    implementation ("com.squareup.okhttp3:okhttp:3.14.9")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:3.12.1")

    implementation ("com.github.bumptech.glide:glide:4.14.2")
    implementation ("com.github.bumptech.glide:okhttp3-integration:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
}