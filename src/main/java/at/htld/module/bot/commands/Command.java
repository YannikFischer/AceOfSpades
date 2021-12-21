package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;

public interface Command {
    public void execute(Message message);
}
