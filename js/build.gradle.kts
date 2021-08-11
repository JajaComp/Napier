import dependencies.Dep
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("js")
}

dependencies {
    implementation(project(":napier"))
    implementation(project(":mpp-sample"))

    implementation(Dep.Kotlin.js)
    implementation(Dep.Coroutines.core)
}

kotlin {
    target {
        browser {
            // execute :js:browserRun to launch dev server
            runTask {
                devServer = KotlinWebpackConfig.DevServer(
                    true, false, true, true, false,
                    8080,
                    null,
                    listOf("${projectDir}/src/main/resources".toString())
                )
                outputFileName = "main.js"
            }
            // execute :js:browserWebpack to build webpack bundle in `./build/distributions`
            webpackTask {
                outputFileName = "main.js"
            }
        }
    }
}
