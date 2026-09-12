package com.example.script;

import com.projectx.game.items.Item;
import com.projectx.script.JavaScript;
import com.projectx.script.ScriptDescription;
import com.projectx.script.Wait;

import static com.projectx.script.api.APIKt.getInventory;
import static com.projectx.script.api.APIKt.interactClosestObject;

@ScriptDescription(
    name = "Example Java Woodcutter",
    version = "1.0.0",
    author = "Your Name",
    description = "The same script in Java: chop a tree, wait for the outcome, drop when full."
)
public class ExampleJavaWoodcutter extends JavaScript {

    @Override
    public Wait onLoop() {
        if (getInventory().isFull()) {
            return dropOneLog();
        }

        // Returns false when nothing matched, so the script idles instead of spinning.
        if (interactClosestObject("Tree", "Chop down", 20)) {
            return Wait.xpDrop();
        }
        return Wait.ms(320, 200);
    }

    private Wait dropOneLog() {
        for (Item item : getInventory()) {
            if (item.getName().endsWith("logs")) {
                item.click("Drop");
                return Wait.until(() -> !getInventory().isFull(), 3000);
            }
        }
        return Wait.ms(400);
    }
}
