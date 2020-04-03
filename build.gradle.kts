plugins {
    java
    // Gradle plugin for handling jfx.
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "se.newton.sysjg3.newtonchess"
version = "1.0-SNAPSHOT"

application {
    applicationName = "Newtonchess - JavaFX Edition"
    mainClassName = "se.newton.sysjg3.newtonchess.Launcher"
}


repositories {
    mavenCentral()
}

dependencies {
    compile("org.slf4j:slf4j-simple:1.7.21")
    compile("commons-io:commons-io:2.6")
    implementation("com.squareup.retrofit2:retrofit:2.8.1")
    implementation("com.squareup.retrofit2:converter-gson:2.8.1")
}

javafx {
    version = "11"
    modules("javafx.controls", "javafx.fxml")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}