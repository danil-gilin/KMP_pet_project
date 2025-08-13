plugins {
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.moko.res)
    alias(libs.plugins.sqldelight)
}

kotlin {
    jvm()
    androidTarget()
    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.components.resources)

                // Settings
                implementation(libs.settings)
                // Resources
                api(libs.moko.resources.compose)
                api(libs.moko.resources.core)
                // DI
                api(project.dependencies.platform(libs.koin.bom))
                api(libs.koin.core)

                implementation(libs.datetime)

                // DataBase
                implementation(libs.sqldelight.coroutines.extensions)
            }
        }

        androidMain {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.sqldelight.android.driver)
            }
        }

        jvmMain {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.sqldelight.desktop.driver)
            }
        }

        val iosArm64Main by getting
        val iosX64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosArm64Main.dependsOn(this)
            iosX64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.sqldelight.native.driver)
            }
        }
    }
}

multiplatformResources {
    resourcesPackage.set("info.javaway.spend_sense")
}


android {
    namespace = findProperty("app.namespace").toString()
    compileSdk = findProperty("android.compileSdk").toString().toInt()
    defaultConfig {
        minSdk = findProperty("android.minSdk").toString().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("AppDb") {
            packageName.set("info.javaway.spend_sense.db")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/db"))
        }
    }
}