package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

/**
 * Simple discord command - returns a Pong message
 *
 * @author KAUF 2021-11-01
 */
public class PingCommand implements Command {

    /**
     * Implementation of a ping command
     *
     * @param message discord message
     */
    @Override
    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();
        channel.createMessage("Pong! - Hello " + message.getUserData().username()).block();
    }
}
