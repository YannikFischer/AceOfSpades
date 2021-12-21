package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
import java.util.Random;

public class Slots implements Command {
        String[] reelArray = { ":gem:", ":cherries:", ":seven:", ":bell:" };
        Random r = new Random();
        int randomReel = r.nextInt(reelArray.length);
        int randomReelTwo = r.nextInt(reelArray.length);
        int randomReelThree = r.nextInt(reelArray.length);
        int randomReelFour = r.nextInt(reelArray.length);
        int randomReelFive = r.nextInt(reelArray.length);
        int randomReelSix = r.nextInt(reelArray.length);
        int randomReelSeven = r.nextInt(reelArray.length);
        int randomReelEight = r.nextInt(reelArray.length);
        int randomReelNine = r.nextInt(reelArray.length);

        EmbedCreateSpec embedCatch = EmbedCreateSpec.builder().color(Color.RED)
                        .author("Slots", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                        .title("Please write a number after $slots ! Or Make a new Wallet with $bal")
                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

        EmbedCreateSpec embedCatchString = EmbedCreateSpec.builder().color(Color.RED)
                        .author("Slots", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                        .title("Please write a number after $slots !")
                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

        EmbedCreateSpec embedIfTooLong = EmbedCreateSpec.builder().color(Color.RED)
                        .author("Error", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                        .title("Max Bet is 9999")
                        .footer("AceOfSpades", "attachment://AceOfSpades.png")
                        .build();

        @Override

        public void execute(Message message) {

                if (message.getAuthor().get().isBot()) {
                        return;
                }

                final MessageChannel channel = message.getChannel().block();

                try {
                        String userBet = message.getContent().substring(7);

                        try {
                                if (userBet.length() > 4) {
                                        InputStream aceOfSpades = null;
                                        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                        channel.createMessage(MessageCreateSpec.builder()
                                                        .addFile("AceOfSpades.png", aceOfSpades)
                                                        .addEmbed(embedIfTooLong).build()).block();
                                } else {
                                        int userBetInt = Integer.parseInt(userBet);

                                        int balance = Balance.users.get(message.getUserData().username());

                                        int userBetIntWinHuge = userBetInt * 5;
                                        int userBetIntWinSmall = userBetInt * 2;

                                        String userBetIntWinHugeString = Integer.toString(userBetIntWinHuge);
                                        String userBetIntWinSmallString = Integer.toString(userBetIntWinSmall);

                                        EmbedCreateSpec slotsWinHuge = EmbedCreateSpec.builder().color(Color.YELLOW)
                                                        .author("Slots",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("BIG WIN")
                                                        .addField("You got: ", userBetIntWinHugeString + " cash", false)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec slotsWinSmall = EmbedCreateSpec.builder().color(Color.BLUE)
                                                        .author("Slots",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("You won!")
                                                        .addField("You got: ", userBetIntWinSmallString + " cash",
                                                                        false)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec slotsLoss = EmbedCreateSpec.builder().color(Color.RED)
                                                        .author("Slots",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("You lost.")
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec slotsMessage = EmbedCreateSpec.builder().color(Color.GREEN)
                                                        .author("Slots",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title(reelArray[randomReel] + " " + reelArray[randomReelTwo]
                                                                        + " "
                                                                        + reelArray[randomReelThree] + "\n"
                                                                        + reelArray[randomReelFour] + " "
                                                                        + reelArray[randomReelFive]
                                                                        + " "
                                                                        + reelArray[randomReelSix] + "\n"
                                                                        + reelArray[randomReelSeven] + " "
                                                                        + reelArray[randomReelEight]
                                                                        + " "
                                                                        + reelArray[randomReelNine])
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        InputStream aceOfSpadesFirst = null;
                                        aceOfSpadesFirst = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                        channel.createMessage(
                                                        MessageCreateSpec.builder()
                                                                        .addFile("AceOfSpades.png", aceOfSpadesFirst)
                                                                        .addEmbed(slotsMessage).build())
                                                        .block();

                                        if (randomReel == randomReelTwo && randomReel == randomReelThree
                                                        || randomReelFour == randomReelFive
                                                                        && randomReelFive == randomReelSix
                                                        || randomReelSeven == randomReelEight
                                                                        && randomReelEight == randomReelNine
                                                        || randomReel == randomReelFive
                                                                        && randomReelFive == randomReelNine
                                                        || randomReelSeven == randomReelFive
                                                                        && randomReelFive == randomReelThree) {
                                                balance += userBetInt * 5;
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(slotsWinHuge)
                                                                .build()).block();
                                        } else if (randomReel == randomReelTwo) {
                                                balance += userBetInt * 1.5;
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(slotsWinSmall)
                                                                .build()).block();
                                        } else if (randomReelFour == randomReelFive) {
                                                balance += userBetInt * 1.5;
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(slotsWinSmall)
                                                                .build()).block();
                                        } else if (randomReelSeven == randomReelEight) {
                                                balance += userBetInt * 1.5;
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(slotsWinSmall)
                                                                .build()).block();
                                        } else {
                                                balance -= userBetInt;
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(slotsLoss)
                                                                .build()).block();
                                        }

                                        Balance.users.put(message.getUserData().username(), balance);
                                }
                        } catch (Exception e) {
                                InputStream aceOfSpades = null;
                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                channel.createMessage(MessageCreateSpec.builder()
                                                .addFile("AceOfSpades.png", aceOfSpades).addEmbed(embedCatch).build())
                                                .block();
                        }
                } catch (Exception e) {
                        InputStream aceOfSpades = null;
                        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                        channel.createMessage(MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                                        .addEmbed(embedCatchString).build()).block();
                }
        }
}
