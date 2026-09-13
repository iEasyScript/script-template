package com.example.script;

import com.projectx.game.items.Item;
import com.projectx.script.BooleanConfigItem;
import com.projectx.script.ConfigurableScript;
import com.projectx.script.JavaScript;
import com.projectx.script.ScriptDescription;
import com.projectx.script.Wait;
import org.projectx.core.game.skill.Skill;

import static com.projectx.script.api.APIKt.getInventory;
import static com.projectx.script.api.APIKt.interactClosestObject;
import static com.projectx.ui.backend.dsl.Overlay.*;

@ScriptDescription(
    name = "Example Java Woodcutter",
    version = "1.0.0",
    author = "Your Name",
    description = "The same script in Java: chop a tree, wait for the outcome, drop when full."
)
public class ExampleJavaWoodcutter extends JavaScript implements ConfigurableScript {

    private final BooleanConfigItem dropLogs =
        new BooleanConfigItem("Drop logs", "Drop logs when the inventory fills instead of stopping.", true);

    private int logsChopped;

    @Override
    public Wait onLoop() {
        if (getInventory().isFull()) {
            return dropLogs.getValue() ? dropOneLog() : Wait.ms(600, 200);
        }

        // Returns false when nothing matched, so the script idles instead of spinning.
        if (interactClosestObject("Tree", "Chop down")) {
            return Wait.sequence(
                () -> Wait.xpDrop(Skill.WOODCUTTING),
                () -> {
                    logsChopped++;
                    return Wait.ms(240, 90);
                });
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

    @Override
    public void render() {
        window("Example Java Woodcutter", w -> {
            text(w, "Logs chopped: " + logsChopped);
            xpProgressBar(w, Skill.WOODCUTTING);
        });
    }
}
