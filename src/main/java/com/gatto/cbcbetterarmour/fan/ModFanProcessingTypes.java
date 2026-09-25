package com.gatto.cbcbetterarmour.fan;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFanProcessingTypes {
    public static final DeferredRegister<FanProcessingType> FAN_PROCESSING_TYPES =
            DeferredRegister.create(CreateRegistries.FAN_PROCESSING_TYPE, CBCBetterArmourMod.MOD_ID);

    public static final Supplier<AcidWashingType> ACID_WASHING = FAN_PROCESSING_TYPES.register("acid_washing", AcidWashingType::new);

    public static void register(IEventBus eventBus) {
        FAN_PROCESSING_TYPES.register(eventBus);
    }
}
