subprojects {
    group = "dev.rikka.tools.materialthemebuilder"
    version = "1.4.0"

    plugins.withId("java") {
        println("- Configuring `java`")

        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        tasks.register("sourcesJar", type = Jar::class) {
            archiveClassifier.set("sources")
            from(project.extensions.getByType<SourceSetContainer>().getByName("main").allSource)
        }
        tasks.register("javadocJar", type = Jar::class) {
            archiveClassifier.set("javadoc")
            from(tasks["javadoc"])
        }
        tasks.withType(Javadoc::class) {
            isFailOnError = false
        }
    }
    plugins.withId("maven-publish") {
        println("- Configuring `publishing`")

        afterEvaluate {
            extensions.configure<PublishingExtension> {
                publications {
                    withType(MavenPublication::class) {
                        version = project.version.toString()
                        group = project.group.toString()

                        pom {
                            name.set("MaterialThemeBuilder")
                            description.set("A gradle plugin that generates Material Design 3 themes for Android projects.")
                            url.set("https://github.com/RikkaApps/MaterialThemeBuilder/")
                            licenses {
                                license {
                                    name.set("MIT License")
                                    url.set("https://raw.githubusercontent.com/RikkaApps/MaterialThemeBuilder/master/LICENSE")
                                }
                            }
                            developers {
                                developer {
                                    name.set("RikkaW")
                                }
                            }
                            scm {
                                connection.set("scm:git:https://github.com/RikkaApps/MaterialThemeBuilder.git")
                                url.set("https://github.com/RikkaApps/MaterialThemeBuilder/")
                            }
                        }
                    }
                }
                repositories {
                    mavenLocal()
                    maven {
                        name = "ossrh"
                        url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
                        credentials(PasswordCredentials::class.java)
                    }
                }
            }
        }
        plugins.withId("signing") {
            println("- Configuring `signing`")

            afterEvaluate {
                extensions.configure<SigningExtension> {
                    if (findProperty("signing.gnupg.keyName") != null) {
                        useGpgCmd()

                        val signingTasks = sign(extensions.getByType<PublishingExtension>().publications)
                        tasks.withType(AbstractPublishToMaven::class) {
                            dependsOn(signingTasks)
                        }
                    }
                }
            }
        }
    }
}
