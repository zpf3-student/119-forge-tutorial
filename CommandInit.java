package com.example.tutorial.core.init;

import com.example.tutorial.common.commands.TestCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommandInit
{
    @SubscribeEvent
    public static void registerModCommands(final RegisterCommandsEvent event)
    {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        // register commands
        TestCommand.register(dispatcher);
    }
}