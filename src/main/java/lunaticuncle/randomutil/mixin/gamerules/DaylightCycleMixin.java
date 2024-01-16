package lunaticuncle.randomutil.mixin.gamerules;

import lunaticuncle.randomutil.RandomUtilities;
import net.minecraft.core.data.gamerule.GameRule;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = World.class, remap = false)
public abstract class DaylightCycleMixin {

	@Shadow
	public abstract <T> T getGameRule(GameRule<T> gameRule);

	@ModifyVariable(method = "tick", at = @At("STORE"), ordinal = 0)
	private long checkDaylightCycleRule(long nextWorldTime) {
		if(!(Boolean)this.getGameRule(RandomUtilities.DAYLIGHT_CYCLE)) {
			return nextWorldTime - 1;
		}
		return nextWorldTime;
	}

}
