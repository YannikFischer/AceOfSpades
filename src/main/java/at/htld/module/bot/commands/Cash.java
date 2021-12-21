package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
import java.util.Random;

public class Cash implements Command {
    Random r = new Random();
    int randomCash = r.nextInt(250);

    String randomCashString = Integer.toString(randomCash);

    EmbedCreateSpec embed = EmbedCreateSpec.builder().color(Color.BLUE).title("You got:")
            .author("Cash", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
            .description(randomCashString).footer("AceOfSpades", "attachment://AceOfSpades.png").build();

    EmbedCreateSpec embedCatch = EmbedCreateSpec.builder().color(Color.RED)
            .author("Error", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
            .title("Please make a new Wallet with $bal")
            .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        try {
            Integer balance = Balance.users.get(message.getUserData().username());

            balance += randomCash;

            Balance.users.put(message.getUserData().username(), balance);

            InputStream aceOfSpades = null;
            aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
            InputStream coinImage = null;
            coinImage = ClassLoader.getSystemResourceAsStream("CoinImage.png");
            channel.createMessage(MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                    .addFile("CoinImage.png", coinImage).addEmbed(embed).build()).block();
        } catch (Exception e) {
            InputStream aceOfSpades = null;
            aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
            channel.createMessage(MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                    .addEmbed(embedCatch).build()).block();
        }
    }
}
