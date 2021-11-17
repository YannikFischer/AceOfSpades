package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;

/**
 * Interface for a command
 *
 * @author KAUF 2021-11-01
 */
public interface Command {

    /**
     * Given method for each command
     * @param message discord message
     */
    public void execute(Message message);
}
