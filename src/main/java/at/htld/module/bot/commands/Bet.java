package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import java.util.Random;

public class Bet implements Command {

    Random r = new Random();
    int randomBet = r.nextInt(9);

    @Override

    public void execute(Message message) {
        String userBet = message.getContent().substring(5);
        final MessageChannel channel = message.getChannel().block();
        channel.createMessage("```Computers guess: " + randomBet + "```").block();

        int userBetInt = Integer.parseInt(userBet);

        if (randomBet > 4) {
            Balance.balance += userBetInt * 2;
        } else {
            Balance.balance -= userBetInt;
        }
    }
}