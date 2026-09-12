# My Scripts — a Project X script starter

A working starter project for writing your own Project X scripts. Clone it,
rename it, and start writing.

## Setup

1. Download the API jars from the
   [script-api releases](https://github.com/iEasyScript/script-api/releases)
   and put them in `libs/`.
2. Build and install:

```bash
./gradlew installScripts
```

That copies the jar to `~/.projectx/scripts/`, where the engine loads it.

You need JDK 25.

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
