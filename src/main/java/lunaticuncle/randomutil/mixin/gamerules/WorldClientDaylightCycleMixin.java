package lunaticuncle.randomutil.mixin.gamerules;

import lunaticuncle.randomutil.RandomUtilities;
import net.minecraft.client.world.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WorldClient.class, remap = false)
public abstract class WorldClientDaylightCycleMixin extends WorldDaylightCycleMixin{

	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/WorldClient;setWorldTime(J)V"))
	private void checkDaylightCycleRule(WorldClient instance, long l) {
		if((Boolean)this.getGameRule(RandomUtilities.DAYLIGHT_CYCLE)) {
			instance.setWorldTime(l);
		}
	}

}
