package me.carlettos.sculk_blockset.forge;

import me.carlettos.sculk_blockset.SculkBlockset;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SculkBlockset.MOD_ID)
public final class SculkBlocksetForge {
    public SculkBlocksetForge() {
        EventBuses.registerModEventBus(SculkBlockset.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SculkBlockset.init();
    }
}
