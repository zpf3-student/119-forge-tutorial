package com.example.tutorial.common.commands;

import com.example.tutorial.TutorialMain;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class TestCommand
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        LiteralArgumentBuilder<CommandSourceStack> testCommand =
                Commands.literal(TutorialMain.MODID)
                        .requires(context -> context.hasPermission(4))
                        .then(Commands.literal("test")
                                .executes(context -> execute(context))
                        )
                ;
        dispatcher.register(testCommand);
    }

    static int execute(CommandContext<CommandSourceStack> context)
    {
        try {
            ServerPlayer player = context.getSource().getPlayerOrException();

            player.displayClientMessage(Component.translatable("Command output....."), true);
        }
        catch (CommandSyntaxException e) { TutorialMain.LOGGER.error(e.getMessage()); }

        return Command.SINGLE_SUCCESS;
    }
}
