package at.htld.module.bot.commands;

import java.io.InputStream;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

public class PingCommand implements Command {
    @Override
    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        EmbedCreateSpec embedPingMessage = EmbedCreateSpec.builder().color(Color.GREEN)
                .author("Ping", "https://github.com/YannikFischer/AceOfSpades",
                        "attachment://CoinImage.png")
                .title("Pong! - Hello " + message.getUserData().username())
                .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

        InputStream aceOfSpades = null;
        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
        channel.createMessage(
                MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades).addEmbed(embedPingMessage).build())
                .block();
    }
}
