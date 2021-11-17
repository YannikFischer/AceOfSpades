package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Reverse implements Command {
    @Override

    public void execute(Message message) {
        String userMessage = message.getContent().substring(9);
        String userMessageReverse = "";

        for (int i = userMessage.length() - 1; i >= 0; i--) {
            userMessageReverse += userMessage.charAt(i);
        }

        final MessageChannel channel = message.getChannel().block();
        channel.createMessage("```" + userMessageReverse + "```").block();
    }
}