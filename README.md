# My Scripts — a Project X script starter

A working starter project for writing your own Project X scripts. Clone it,
rename it, and start writing.

## Setup

1. Download or clone this repository.
2. Open the folder in IntelliJ IDEA (File → Open) and let the Gradle sync finish.

That's it. The build downloads the script API itself, so there are no jars to
fetch by hand, and a JDK 25 is downloaded for the build if you do not have one.
The API version lives in `gradle.properties`; bump it when the engine updates and
reload the Gradle project.

Build and install:

```bash
./gradlew installScripts
```

That copies the jar to `~/.projectx/scripts/`, where the engine loads it.

If the editor shows `Cannot resolve symbol` on `com.projectx` imports, the Gradle
sync has not finished or failed: open the Gradle tool window and press Reload.

## What's here

Two complete, working scripts that do the same job in different languages:

- `src/main/kotlin/com/example/script/ExampleWoodcutter.kt`
- `src/main/java/com/example/script/ExampleJavaWoodcutter.java`

Both show the annotation the engine discovers scripts by, outcome-gated waiting
and randomised delays. The Kotlin one also has a user-facing config item.

Delete whichever language you do not want, rename the package and class, and you
have your own script. Both can also coexist in one jar.

## Next

Read [WRITING-SCRIPTS.md](https://github.com/iEasyScript/script-api/blob/main/WRITING-SCRIPTS.md)
in the script-api repository for the full guide.
