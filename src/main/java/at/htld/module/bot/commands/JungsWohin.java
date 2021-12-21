package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
import java.util.Random;

public class JungsWohin implements Command {

    Random r = new Random();

    String[] wohin = { "Mci", "Burger King", "Messpark", "Lidl", "Bäckerei", "Pizza Box", "Bestellen", "Charly" };

    int randomWohin = r.nextInt(wohin.length);

    EmbedCreateSpec embed = EmbedCreateSpec.builder().color(Color.BLUE).title("Wir gehen")
            .description(wohin[randomWohin]).footer("AceOfSpades", "attachment://AceOfSpades.png").build();

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        InputStream aceOfSpades = null;
        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");

        channel.createMessage(
                MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades).addEmbed(embed).build()).block();
    }
}
