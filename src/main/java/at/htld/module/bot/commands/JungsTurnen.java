package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
import java.util.Random;

public class JungsTurnen implements Command {

    Random r = new Random();

    String[] turnen = { "Volleyball", "Völkerball", "One Touch", "Basketball" };

    int randomturnen = r.nextInt(turnen.length);

    EmbedCreateSpec embed = EmbedCreateSpec.builder().color(Color.BLUE).title("Wir machen")
            .description(turnen[randomturnen]).footer("AceOfSpades", "attachment://AceOfSpades.png").build();

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        InputStream aceOfSpades = null;
        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");

        channel.createMessage(
                MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades).addEmbed(embed).build()).block();
    }
}
