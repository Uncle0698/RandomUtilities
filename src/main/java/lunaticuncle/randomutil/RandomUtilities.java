package lunaticuncle.randomutil;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.data.gamerule.GameRuleBoolean;
import net.minecraft.core.data.gamerule.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RandomUtilities implements ModInitializer {
    public static final String MOD_ID = "unclerandomutilities";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static GameRuleBoolean FIRE_TICKS = (GameRuleBoolean) GameRules.register(new GameRuleBoolean("doFireTick", true));


    @Override
    public void onInitialize() {
        LOGGER.info("Uncle's Random Utilities initialized.");
    }

}
