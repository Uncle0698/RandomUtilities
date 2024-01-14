package lunaticuncle.randomutil.mixin;

import net.minecraft.core.data.gamerule.GameRuleBoolean;
import net.minecraft.core.data.gamerule.GameRules;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.core.data.gamerule.GameRules.register;


@Mixin(value = GameRules.class, remap = false)
public abstract class GameRulesMixin {
		static GameRuleBoolean FIRE_TICKS = (GameRuleBoolean) register(new GameRuleBoolean("doFireTick", true));


}
