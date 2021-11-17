package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import java.util.Random;

public class Slots implements Command {
    String[] reelArray = { ":diamond_shape_with_a_dot_inside:", ":large_blue_diamond:", ":large_orange_diamond:" };
    Random r = new Random();
    int randomReel = r.nextInt(reelArray.length);
    int randomReelTwo = r.nextInt(reelArray.length);
    int randomReelThree = r.nextInt(reelArray.length);

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        String userBet = message.getContent().substring(7);

        try {
            Integer.parseInt(userBet);
        } catch (Exception e) {
            channel.createMessage("```Please write a number after the $slots!```").block();
        }

        int userBetInt = Integer.parseInt(userBet);

        channel.createMessage(reelArray[randomReel] + " " + reelArray[randomReelTwo] + " " + reelArray[randomReelThree])
                .block();

        if (randomReel == randomReelTwo && randomReel == randomReelThree) {
            Balance.balance += userBetInt * 5;
            channel.createMessage("```You won " + userBetInt * 4 + " Cash!```").block();
        } else if (randomReel == randomReelThree) {
            Balance.balance += userBetInt * 1.5;
            channel.createMessage("```You won " + userBetInt * 1.5 + " Cash!```").block();
        } else if (randomReelTwo == randomReelThree) {
            Balance.balance += userBetInt * 1.5;
            channel.createMessage("```You won " + userBetInt * 1.5 + " Cash!```").block();
        } else if (randomReel == randomReelTwo) {
            Balance.balance += userBetInt * 1.5;
            channel.createMessage("```You won " + userBetInt * 1.5 + " Cash!```").block();
        } else {
            Balance.balance -= userBetInt;
            channel.createMessage("```You lost " + userBetInt + " Cash```").block();
        }
    }
}
