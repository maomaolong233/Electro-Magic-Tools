ElectricMagicTools
==================

An IC2/TC4 crossover addon

#This project is discontinued. It will recieve no more updates. There may be unofficial forks floating around.

## Development setup

This project uses ForgeGradle 1.2 for Minecraft 1.7.10. ForgeGradle 1.2 applies Gradle's legacy `maven` plugin, which Gradle 7 and later no longer provide. Therefore, import and build the project with the included Gradle 2.1 wrapper, not an IDE-installed Gradle 8.x distribution.

* In IntelliJ IDEA, open **Settings → Build, Execution, Deployment → Build Tools → Gradle** and set **Gradle distribution** to **`gradle-wrapper.properties`**.
* Run `gradlew` on Windows or `./gradlew` on Unix-like systems. Do not run a system-installed `gradle` command for this project.

### GTNH ExampleMod migration

When moving this mod into the GTNH `ExampleMod1.7.10` template, retain the template's `settings.gradle.kts`, `build.gradle.kts`, and Gradle wrapper. Copy this project's source and resources, then use the `modGroup`, `modId`, `modName`, and `modVersion` values from `gradle.properties`. Do not copy this project's legacy `build.gradle` into the template: it uses ForgeGradle 1.2 rather than the GTNH convention plugin.
