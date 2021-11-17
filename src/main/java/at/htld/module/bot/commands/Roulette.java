package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
//import discord4j.discordjson.json.UserData;
import java.util.Random;

public class Roulette implements Command {

    int rouletteNumber;

    Random r = new Random();
    int randomRoulette = r.nextInt(36);

    Integer[] rollArrayBlack = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35 };
    Integer[] rollArrayRed = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36 };

    @Override

    public void execute(Message message) {
        String userNumber = message.getContent().substring(6);
        int userNumberInt = Integer.parseInt(userNumber);

        final MessageChannel channel = message.getChannel().block();
        if (userNumberInt > 36) {
            channel.createMessage("```Your Number is too high! Choose a number between 0 and 36!```").block();
        } else {
            channel.createMessage("```Your Number: " + userNumberInt + "```").block();
            channel.createMessage("```Number rolled: " + randomRoulette + "```").block();

            if (userNumberInt == randomRoulette) {
                Balance.balance += 1000;
                channel.createMessage("```You won: " + 2000 + " Cash!```").block();
            }

            /*
             * } else if (randomRoulette == rollArrayBlack[] && userNumber ==
             * rollArrayBlack[]) { Balance.balance += 100;
             * channel.createMessage("```You won: " + 100 + " Cash!```").block(); } else if
             * (randomRoulette == rollArrayRed[] && userNumber == rollArrayRed[]) {
             * Balance.balance += 100; channel.createMessage("```You won: " + 100 +
             * " Cash!```").block(); } else { Balance.balance -= 100;
             * channel.createMessage("```You lost: " + 100 + " Cash```").block(); }
             */
        }
    }
}
