package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
import java.util.Random;

public class Gamble implements Command {
        Random rand = new Random();
        int number1 = rand.nextInt(10) + 1;
        int number2 = rand.nextInt(10) + 1;

        String number1String = Integer.toString(number1);
        String number2String = Integer.toString(number2);

        EmbedCreateSpec embedCatch = EmbedCreateSpec.builder().color(Color.RED)
                        .author("Error", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                        .title("Please write a number after $gamble ! Or Make a new Wallet with $bal")
                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

        EmbedCreateSpec embedCatchString = EmbedCreateSpec.builder().color(Color.RED)
                        .author("Error", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                        .title("Please write a number after $gamble !")
                        .footer("AceOfSpades", "attachment://AceOfSpades.png")
                        .build();

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
                        String userBetString = message.getContent().substring(8);

                        try {
                                if (userBetString.length() > 4) {
                                        InputStream aceOfSpades = null;
                                        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                        channel.createMessage(MessageCreateSpec.builder()
                                                        .addFile("AceOfSpades.png", aceOfSpades)
                                                        .addEmbed(embedIfTooLong).build()).block();
                                } else {
                                        int balance = Balance.users.get(message.getUserData().username());

                                        int userBet = Integer.parseInt(userBetString);
                                        int userBetWin = userBet * 2;

                                        EmbedCreateSpec embedWin = EmbedCreateSpec.builder().color(Color.BLUE)
                                                        .author("Gamble",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("You Win!")
                                                        .addField("Your Number : ", number1String, true)
                                                        .addField("Gambler's Number : ", number2String, true)
                                                        .addField("You won : ", userBetWin + " cash", true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png")
                                                        .build();

                                        EmbedCreateSpec embedLoss = EmbedCreateSpec.builder().color(Color.RED)
                                                        .author("Gamble",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("You Lost.")
                                                        .addField("Your Number : ", number1String, true)
                                                        .addField("Gambler's Number : ", number2String, true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png")
                                                        .build();

                                        EmbedCreateSpec embedDraw = EmbedCreateSpec.builder().color(Color.YELLOW)
                                                        .author("Gamble",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("It's a Draw!")
                                                        .addField("Your Number : ", number1String, true)
                                                        .addField("Gambler's Number : ", number2String, true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png")
                                                        .build();

                                        if (number1 == number2) {
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                InputStream coinImage = null;
                                                coinImage = ClassLoader.getSystemResourceAsStream("CoinImage.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addFile("CoinImage.png", coinImage).addEmbed(embedDraw)
                                                                .build()).block();
                                        } else if (number1 > number2) {
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                InputStream coinImage = null;
                                                coinImage = ClassLoader.getSystemResourceAsStream("CoinImage.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addFile("CoinImage.png", coinImage).addEmbed(embedWin)
                                                                .build()).block();
                                                balance += userBet;
                                        } else {
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                InputStream coinImage = null;
                                                coinImage = ClassLoader.getSystemResourceAsStream("CoinImage.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addFile("CoinImage.png", coinImage).addEmbed(embedLoss)
                                                                .build()).block();
                                                balance -= userBet;
                                        }

                                        Balance.users.put(message.getUserData().username(), balance);
                                }
                        } catch (Exception e) {
                                InputStream aceOfSpades = null;
                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                channel.createMessage(
                                                MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(embedCatch).build())
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