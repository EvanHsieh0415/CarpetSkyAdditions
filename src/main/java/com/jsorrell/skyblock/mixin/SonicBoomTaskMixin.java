package com.jsorrell.skyblock.mixin;

import com.jsorrell.skyblock.SkyBlockSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.SonicBoomTask;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SonicBoomTask.class)
public class SonicBoomTaskMixin {
  @Inject(method = "method_43265", at = @At(value = "TAIL"))
  private static void dropEchoShard(WardenEntity wardenEntity, ServerWorld serverWorld, LivingEntity target, CallbackInfo ci) {
    if (SkyBlockSettings.renewableEchoShards) {
      if (target instanceof DolphinEntity || target instanceof BatEntity) {
        if (target.isDead()) {
          target.dropItem(Items.ECHO_SHARD);
        }
      }
    }
  }
}
