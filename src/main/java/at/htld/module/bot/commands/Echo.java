package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Echo implements Command {
    @Override

    public void execute(Message message) {
        String userMessage = message.getContent().substring(6);
        final MessageChannel channel = message.getChannel().block();
        channel.createMessage("```" + userMessage + "```").block();
    }
}