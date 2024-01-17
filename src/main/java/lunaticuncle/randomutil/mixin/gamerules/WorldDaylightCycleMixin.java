package lunaticuncle.randomutil.mixin.gamerules;

import lunaticuncle.randomutil.RandomUtilities;
import net.minecraft.core.data.gamerule.GameRule;
import net.minecraft.core.world.ProgressListener;
import net.minecraft.core.world.World;
import net.minecraft.core.world.save.LevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.LocalDateTime;

@Mixin(value = World.class, remap = false)
public abstract class WorldDaylightCycleMixin {

	@Shadow
	public abstract <T> T getGameRule(GameRule<T> gameRule);

	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/save/LevelData;setWorldTime(J)V"))
	private void checkDaylightCycleRule(LevelData instance, long l) {
		if((Boolean)this.getGameRule(RandomUtilities.DAYLIGHT_CYCLE)) {
			instance.setWorldTime(l);
		}
	}

	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/save/LevelData;getWorldTime()J"))
	private long fixAutoSave(LevelData instance) {
		if((Boolean)this.getGameRule(RandomUtilities.DAYLIGHT_CYCLE)) {
			return instance.getWorldTime();
		} else {
			LocalDateTime now = LocalDateTime.now();
			return (long)(now.getSecond()) * 20L - 1L;
		}
	}

}
