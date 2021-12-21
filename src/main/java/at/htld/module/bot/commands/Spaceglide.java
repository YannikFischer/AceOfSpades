package at.htld.module.bot.commands;

import java.io.InputStream;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

public class Spaceglide implements Command {
    @Override
    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        EmbedCreateSpec embed = EmbedCreateSpec.builder().color(Color.GREEN)
                .author("Spaceglide", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                .image("attachment://Anton.jpg")
                .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

        InputStream aceOfSpades = null;
        InputStream anton = null;
        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
        anton = ClassLoader.getSystemResourceAsStream("Anton.jpg");
        channel.createMessage(
                MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades).addFile("Anton.jpg", anton)
                        .addEmbed(embed).build())
                .block();
    }
}
