ElectricMagicTools
==================

An IC2/TC4 crossover addon

#This project is discontinued. It will recieve no more updates. There may be unofficial forks floating around.

## Development setup

This project uses ForgeGradle 1.2 for Minecraft 1.7.10. ForgeGradle 1.2 applies Gradle's legacy `maven` plugin, which Gradle 7 and later no longer provide. Therefore, import and build the project with the included Gradle 2.1 wrapper, not an IDE-installed Gradle 8.x distribution.

* In IntelliJ IDEA, open **Settings → Build, Execution, Deployment → Build Tools → Gradle** and set **Gradle distribution** to **`gradle-wrapper.properties`**.
* Run `gradlew` on Windows or `./gradlew` on Unix-like systems. Do not run a system-installed `gradle` command for this project.
