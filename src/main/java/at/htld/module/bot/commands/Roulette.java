package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
//import discord4j.discordjson.json.UserData;
import java.util.Random;

public class Roulette implements Command {
        @Override

        public void execute(Message message) {
                final MessageChannel channel = message.getChannel().block();

                EmbedCreateSpec embedCatch = EmbedCreateSpec.builder().color(Color.RED)
                                .author("Error", "https://github.com/YannikFischer/AceOfSpades",
                                                "attachment://CoinImage.png")
                                .title("Please write a number after $roll ! Or Make a new Wallet with $bal")
                                .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                EmbedCreateSpec embedCatchString = EmbedCreateSpec.builder().color(Color.RED)
                                .author("Error", "https://github.com/YannikFischer/AceOfSpades",
                                                "attachment://CoinImage.png")
                                .title("Please write a number after $roll !")
                                .footer("AceOfSpades", "attachment://AceOfSpades.png")
                                .build();

                EmbedCreateSpec embedIfTooLong = EmbedCreateSpec.builder().color(Color.RED)
                                .author("Error", "https://github.com/YannikFischer/AceOfSpades",
                                                "attachment://CoinImage.png")
                                .title("Max Bet is 9999")
                                .footer("AceOfSpades", "attachment://AceOfSpades.png")
                                .build();

                try {
                        String userMessage = message.getContent().substring(6);
                        String[] userNumberArray = userMessage.split(" ", 5);

                        String userNumber = userNumberArray[0];
                        String userBet = userNumberArray[1];

                        try {
                                if (userBet.length() > 4) {
                                        InputStream aceOfSpades = null;
                                        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                        channel.createMessage(MessageCreateSpec.builder()
                                                        .addFile("AceOfSpades.png", aceOfSpades)
                                                        .addEmbed(embedIfTooLong).build()).block();
                                } else {
                                        Random r = new Random();
                                        int randomRoulette = r.nextInt(36);

                                        String randomRouletteString = Integer.toString(randomRoulette);

                                        Boolean isBlack = false;
                                        Boolean isRed = false;
                                        Boolean isPlayerBlack = false;
                                        Boolean isPlayerRed = false;

                                        int userNumberInt = Integer.parseInt(userNumber);
                                        int userBetInt = Integer.parseInt(userBet);

                                        int winAmount = userBetInt * 2;
                                        int hugeWinAmount = userBetInt * 35;
                                        int lossAmount = userBetInt;

                                        String winAmountString = Integer.toString(winAmount);
                                        String hugeWinAmountString = Integer.toString(hugeWinAmount);
                                        String lossAmountString = Integer.toString(lossAmount);

                                        int balance = Balance.users.get(message.getUserData().username());

                                        EmbedCreateSpec embedWinBlack = EmbedCreateSpec.builder().color(Color.BLUE)
                                                        .author("Roulette",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("Black Wins!")
                                                        .addField("Your Number: ", userNumber, true)
                                                        .addField("Rolled Number: ", randomRouletteString, true)
                                                        .addField("You Won: ", winAmountString + " cash", true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec embedWinRed = EmbedCreateSpec.builder().color(Color.BLUE)
                                                        .author("Roulette",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("Red Wins!").addField("Your Number: ", userNumber, true)
                                                        .addField("Rolled Number: ", randomRouletteString, true)
                                                        .addField("You Won: ", winAmountString + " cash", true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec embedHugeWin = EmbedCreateSpec.builder().color(Color.YELLOW)
                                                        .author("Roulette",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("HUUUUUGE WIN!")
                                                        .addField("Your Number: ", userNumber, true)
                                                        .addField("Rolled Number: ", randomRouletteString, true)
                                                        .addField("You Won: ", hugeWinAmountString + " cash", true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec embedLossBlack = EmbedCreateSpec.builder().color(Color.RED)
                                                        .author("Roulette",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("Black Wins!")
                                                        .addField("Your Number: ", userNumber, true)
                                                        .addField("Rolled Number: ", randomRouletteString, true)
                                                        .addField("You Lost: ", lossAmountString + " cash", true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec embedLossRed = EmbedCreateSpec.builder().color(Color.RED)
                                                        .author("Roulette",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("Red Wins!").addField("Your Number: ", userNumber, true)
                                                        .addField("Rolled Number: ", randomRouletteString, true)
                                                        .addField("You Lost: ", lossAmountString + " cash", true)
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        EmbedCreateSpec embedTooHigh = EmbedCreateSpec.builder().color(Color.RED)
                                                        .author("Roulette",
                                                                        "https://github.com/YannikFischer/AceOfSpades",
                                                                        "attachment://CoinImage.png")
                                                        .title("Choose a number between 0 and 36!")
                                                        .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                                        if (userNumberInt > 36 || userNumberInt < 0) {
                                                InputStream aceOfSpades = null;
                                                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                                                channel.createMessage(MessageCreateSpec.builder()
                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                .addEmbed(embedTooHigh).build()).block();
                                        } else {
                                                if (userNumberInt == randomRoulette) {
                                                        balance += hugeWinAmount;
                                                        Balance.users.put(message.getUserData().username(), balance);
                                                        InputStream aceOfSpades = null;
                                                        aceOfSpades = ClassLoader
                                                                        .getSystemResourceAsStream("AceOfSpades.png");
                                                        channel.createMessage(MessageCreateSpec.builder()
                                                                        .addFile("AceOfSpades.png", aceOfSpades)
                                                                        .addEmbed(embedHugeWin).build()).block();
                                                } else {
                                                        if (randomRoulette % 2 == 0) {
                                                                isRed = true;
                                                        } else if (randomRoulette % 2 > 0) {
                                                                isBlack = true;
                                                        }

                                                        if (userNumberInt % 2 == 0) {
                                                                isPlayerRed = true;
                                                        } else if (userNumberInt % 2 > 0) {
                                                                isPlayerBlack = true;
                                                        }

                                                        if (isBlack == true && isPlayerBlack == true) {
                                                                balance += winAmount;
                                                                InputStream aceOfSpades = null;
                                                                aceOfSpades = ClassLoader
                                                                                .getSystemResourceAsStream(
                                                                                                "AceOfSpades.png");
                                                                channel.createMessage(MessageCreateSpec.builder()
                                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                                .addEmbed(embedWinBlack).build())
                                                                                .block();
                                                        } else if (isRed == true && isPlayerRed == true) {
                                                                balance += winAmount;
                                                                InputStream aceOfSpades = null;
                                                                aceOfSpades = ClassLoader
                                                                                .getSystemResourceAsStream(
                                                                                                "AceOfSpades.png");
                                                                channel.createMessage(MessageCreateSpec.builder()
                                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                                .addEmbed(embedWinRed).build()).block();
                                                        } else if (isBlack == true) {
                                                                balance -= lossAmount;
                                                                InputStream aceOfSpades = null;
                                                                aceOfSpades = ClassLoader
                                                                                .getSystemResourceAsStream(
                                                                                                "AceOfSpades.png");
                                                                channel.createMessage(MessageCreateSpec.builder()
                                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                                .addEmbed(embedLossBlack).build())
                                                                                .block();
                                                        } else {
                                                                balance -= lossAmount;
                                                                InputStream aceOfSpades = null;
                                                                aceOfSpades = ClassLoader
                                                                                .getSystemResourceAsStream(
                                                                                                "AceOfSpades.png");
                                                                channel.createMessage(MessageCreateSpec.builder()
                                                                                .addFile("AceOfSpades.png", aceOfSpades)
                                                                                .addEmbed(embedLossRed).build())
                                                                                .block();
                                                        }
                                                }
                                                Balance.users.put(message.getUserData().username(), balance);
                                        }
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
