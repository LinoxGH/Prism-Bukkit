package me.botsko.prism.commands;

import me.botsko.prism.Il8nHelper;
import me.botsko.prism.Prism;
import me.botsko.prism.commandlibs.CallInfo;
import me.botsko.prism.commandlibs.Flag;
import me.botsko.prism.commandlibs.SubHandler;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class FlagsCommand implements SubHandler {

    /**
     * Handle the command.
     */
    @Override
    public void handle(CallInfo call) {
        help(call.getSender());
    }

    @Override
    public List<String> handleComplete(CallInfo call) {
        return null;
    }

    /**
     * Display param help.
     *
     * @param s CommandSender
     */
    private void help(CommandSender s) {
        Audience sender = Prism.getAudiences().sender(s);
        Prism.messenger.sendMessage(s, Prism.messenger.playerHeaderMsg(
                Il8nHelper.getMessage("flag-help-header").color(NamedTextColor.GOLD)));
        Prism.messenger.sendMessage(s, Prism.messenger.playerMsg(
                Il8nHelper.getMessage("flag-help-1").color(NamedTextColor.GRAY)));
        Prism.messenger.sendMessage(s, Prism.messenger
                .playerMsg(Il8nHelper.getMessage("flag-help-2")));
        for (final Flag flag : Flag.values()) {
            sender.sendMessage(Prism.messenger.playerMsg(
                    Component.text().content(flag.getUsage().replace("_", "-"))
                            .color(NamedTextColor.LIGHT_PURPLE)
                            .append(Component.text(" " + flag.getDescription()))
                            .build()));
        }
    }
}