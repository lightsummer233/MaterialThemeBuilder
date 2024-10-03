plugins {
    java
    `java-gradle-plugin`
    `maven-publish`
    signing
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.android.gradle)
    implementation("com.google.guava:guava:33.3.1-jre")
    compileOnly("androidx.annotation:annotation:1.8.2")
}

sourceSets {
    main {
        java {
            srcDir("$rootDir/material-color-utilities/java")
        }
    }
}

gradlePlugin {
    plugins {
        create("MaterialThemeBuilder") {
            id = project.group.toString()
            displayName = "MaterialThemeBuilder"
            description = "A gradle plugin that generates Material Design 3 themes for Android projects."
            implementationClass = "$id.MaterialThemeBuilderPlugin"
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            named("pluginMaven", MavenPublication::class) {
                artifactId = "gradle-plugin"

                artifact(tasks["sourcesJar"])
//                artifact(tasks["javadocJar"])
            }
        }
    }

    tasks.withType(Jar::class) {
        manifest {
            attributes(mapOf("Implementation-Version" to project.version.toString()))
        }
    }
}
