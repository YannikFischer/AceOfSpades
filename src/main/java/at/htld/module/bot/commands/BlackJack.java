package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import java.util.Random;

public class BlackJack implements Command {

    int bjNumber = 0;
    int bjWin = 100;
    int bjLoss = 200;

    Random r = new Random();
    int randomBjOne = r.nextInt(10) + 1;
    int randomBjTwo = r.nextInt(10) + 1;

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        // String cmd = message.getContent();
        // String[] cmdArray = cmd.split(" ");
        // String command = cmdArray[0];
        // int amount = Integer.parseInt(cmdArray[1]);

        // channel.createMessage("Command: " + command + ", amount: " + (amount *
        // 2)).block();

        bjNumber = randomBjOne + randomBjTwo;

        channel.createMessage("```Your Card Value:" + bjNumber + " ```").block();
        channel.createMessage("```Your Total Card Value:" + bjNumber + " ```").block();

        int randomBjThree = r.nextInt(10);

        bjNumber += randomBjThree;

        channel.createMessage("```Your Card Value:" + randomBjThree + " ```").block();
        channel.createMessage("```Your Total Card Value:" + bjNumber + " ```").block();

        if (bjNumber > 21) {
            Balance.balance -= bjLoss;
            channel.createMessage("```You Lost:" + bjLoss + " Cash```").block();
        } else {
            Balance.balance += bjWin;
            channel.createMessage("```You Won:" + bjWin + " Cash```").block();
        }
    }
}
