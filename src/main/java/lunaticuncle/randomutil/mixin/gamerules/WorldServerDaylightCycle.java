package lunaticuncle.randomutil.mixin.gamerules;

import lunaticuncle.randomutil.RandomUtilities;
import net.minecraft.core.world.save.LevelData;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.server.world.WorldServer;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WorldServer.class, remap = false)
public abstract class WorldServerDaylightCycle extends WorldDaylightCycleMixin{
	@Redirect(method = "updateSleepingPlayers", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/save/LevelData;setWorldTime(J)V"))
	private void fixSleeping(LevelData instance, long l) {
		if((Boolean)this.getGameRule(RandomUtilities.DAYLIGHT_CYCLE)) {
			instance.setWorldTime(l);
		}
	}
}
