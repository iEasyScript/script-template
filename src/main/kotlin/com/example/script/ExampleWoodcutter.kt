package com.example.script

import com.projectx.script.BooleanConfigItem
import com.projectx.script.ConfigurableScript
import com.projectx.script.Script
import com.projectx.script.ScriptDescription
import com.projectx.script.api.interactClosestObject
import com.projectx.script.api.inventory

@ScriptDescription(
    name = "Example Woodcutter",
    version = "1.0.0",
    author = "Your Name",
    description = "A minimal script: chop a tree, wait for the outcome, drop when full.",
)
class ExampleWoodcutter : Script(), ConfigurableScript {

    private val dropLogs = BooleanConfigItem(
        name = "Drop logs",
        description = "Drop logs when the inventory fills instead of stopping.",
        initialValue = true,
    )

    override fun onStart() {
        println("Example Woodcutter started")
    }

    override suspend fun loop() {
        if (inventory.isFull) {
            if (!dropLogs.value) return
            dropOneLog()
            return
        }

        // interactClosest* returns false when nothing matched, so the script
        // idles instead of spinning at full speed.
        if (interactClosestObject("Tree", "Chop down")) {
            waitForXPDrop()
            delay(240, 90)
        } else {
            delay(320, 200)
        }
    }

    private suspend fun dropOneLog() {
        val log = inventory.firstOrNull { it.name.endsWith("logs") } ?: return
        log.click("Drop")
        delay(260, 80)
    }
}
