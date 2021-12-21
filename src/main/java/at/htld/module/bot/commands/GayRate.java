package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
import java.util.Random;

public class GayRate implements Command {

    Random r = new Random();

    int randomGay = r.nextInt(100);

    EmbedCreateSpec embedCatch = EmbedCreateSpec.builder().color(Color.RED)
            .author("Error", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
            .title("Write a Name after $howgayis !").footer("AceOfSpades", "attachment://AceOfSpades.png").build();

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        try {
            String userMessage = message.getContent().substring(10);

            String randomGayRateNumber = Integer.toString(randomGay);

            EmbedCreateSpec embedMessage = EmbedCreateSpec.builder().color(Color.BLUE)
                    .title(userMessage + " is")
                    .description(randomGayRateNumber + "% Gay").footer("AceOfSpades", "attachment://AceOfSpades.png")
                    .build();

            InputStream aceOfSpades = null;
            aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");

            channel.createMessage(
                    MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades).addEmbed(embedMessage).build())
                    .block();
        } catch (Exception e) {
            InputStream aceOfSpades = null;
            aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");

            channel.createMessage(
                    MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades).addEmbed(embedCatch).build())
                    .block();
        }
    }
}
