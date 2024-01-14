package lunaticuncle.randomutil.mixin;

import lunaticuncle.randomutil.commands.SmiteCommand;
import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.Commands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import turniplabs.halplibe.helper.CommandHelper;

@Mixin(value = Commands.class, remap = false)
public abstract class CommandsMixin {
	@Inject(at = @At("TAIL"), method = "initCommands")
	private static void randomutil_initCommands(CallbackInfo ci) {
		CommandHelper.createCommand(new SmiteCommand());
	}
}
