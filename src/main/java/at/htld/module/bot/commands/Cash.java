package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import java.util.Random;

public class Cash implements Command {

    Random r = new Random();
    int randomCash = r.nextInt(50);

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();
        channel.createMessage("```You got: " + randomCash + " Cash!```").block();

        Balance.balance += randomCash;
        // Integer lol = Balance.users.get(message.getUserData().username());

        // lol += randomCash;
        // channel.createMessage("```Your Balance: " +
        // Balance.users.get(message.getUserData().username()) + "```")
        // .block();
    }
}
