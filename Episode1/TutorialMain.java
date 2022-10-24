package com.example.tutorial;

import com.example.tutorial.core.init.CommandInit;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMain.MODID)
public class TutorialMain
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tutorial";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(CommandInit.class);
    }
//    @SubscribeEvent
//    public void onCommandRegister(final RegisterCommandsEvent event)
//    {
//        CommandInit.registerModCommands(event);
//    }
}
