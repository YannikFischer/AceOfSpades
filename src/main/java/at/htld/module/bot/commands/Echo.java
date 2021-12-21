package at.htld.module.bot.commands;

import java.io.InputStream;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

public class Echo implements Command {
    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        EmbedCreateSpec embedCatchMessage = EmbedCreateSpec.builder().color(Color.GREEN)
                .author("Error", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                .title("Please write a message after the $echo !").footer("AceOfSpades", "attachment://AceOfSpades.png")
                .build();

        try {
            String userMessage = message.getContent().substring(6);

            EmbedCreateSpec embedEchoMessage = EmbedCreateSpec.builder().color(Color.GREEN)
                    .author("Echo", "https://github.com/YannikFischer/AceOfSpades",
                            "attachment://CoinImage.png")
                    .title(userMessage).footer("AceOfSpades", "attachment://AceOfSpades.png").build();

            InputStream aceOfSpades = null;
            aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
            channel.createMessage(MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                    .addEmbed(embedEchoMessage).build()).block();
        } catch (Exception e) {
            InputStream aceOfSpades = null;
            aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
            channel.createMessage(MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                    .addEmbed(embedCatchMessage).build()).block();
        }
    }
}