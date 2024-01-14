package lunaticuncle.randomutil;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RandomUtilities implements ModInitializer {
    public static final String MOD_ID = "unclerandomutilities";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Uncle's Random Utilities initialized.");
    }

}
