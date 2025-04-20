plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.flutter_example_flavor"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.flutter_example_flavor"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        buildConfig = true // necessário para usar buildConfigField nos flavors
    }

    flavorDimensions += "flavor" // Define o grupo de sabores (flavors) chamado "flavor"

        productFlavors {
        create("abacaxi") { // Cria o flavor "abacaxi"
            dimension = "flavor" // Associa à dimensão "flavor"
            applicationIdSuffix = ".abacaxi" // Sufixo no ID do app
            versionNameSuffix = "-abacaxi" // Sufixo na versão do app
            resValue("string", "app_name", "App Abacaxi") // Define nome do app para esse flavor
            manifestPlaceholders["flavorName"] = "abacaxi" // Placeholder para usar no AndroidManifest.xml
            buildConfigField("String", "FLAVOR_NAME", "\"abacaxi\"") // Campo de build acessível via código
        }
        create("morango") { // Cria o flavor "morango"
            dimension = "flavor"
            applicationIdSuffix = ".morango"
            versionNameSuffix = "-morango"
            resValue("string", "app_name", "App Morango")
            manifestPlaceholders["flavorName"] = "morango"
            buildConfigField("String", "FLAVOR_NAME", "\"morango\"")
        }
        create("laranja") { // Cria o flavor "laranja"
            dimension = "flavor"
            applicationIdSuffix = ".laranja"
            versionNameSuffix = "-laranja"
            resValue("string", "app_name", "App Laranja")
            manifestPlaceholders["flavorName"] = "laranja"
            buildConfigField("String", "FLAVOR_NAME", "\"laranja\"")
        }
    }
}

flutter {
    source = "../.."
}
