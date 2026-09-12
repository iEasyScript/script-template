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

`src/main/kotlin/com/example/script/ExampleWoodcutter.kt` is a complete, working
script in about 45 lines. It shows the annotation the engine discovers scripts
by, outcome-gated waiting, randomised delays, and a user-facing config item.

Rename the package and the class, and you have your own script.

## Next

Read [WRITING-SCRIPTS.md](https://github.com/iEasyScript/script-api/blob/main/WRITING-SCRIPTS.md)
in the script-api repository for the full guide.
