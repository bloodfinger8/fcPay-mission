plugins {
    id("java")
    kotlin("plugin.jpa")
    id("com.palantir.docker")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java:8.0.32")
}

docker {
    name = "${rootProject.name}-${project.name}:$version"
    setDockerfile(file("../Dockerfile"))
    files(tasks.bootJar.get().outputs.files)
    buildArgs(
        mapOf(
            "PROFILE" to (findProperty("profile") ?: "local").toString(),
            "JAR_FILE" to tasks.bootJar.get().outputs.files.singleFile.name
        )
    )
}