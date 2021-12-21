package at.htld.module.bot.commands;

import java.io.InputStream;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

public class Help implements Command {
        @Override
        public void execute(Message message) {
                final MessageChannel channel = message.getChannel().block();

                EmbedCreateSpec embedPingMessage = EmbedCreateSpec.builder().color(Color.GREEN)
                                .author("Help", "https://github.com/YannikFischer/AceOfSpades",
                                                "attachment://CoinImage.png")
                                .addField("$bal",
                                                "Shows you your Balance, or creates you a Wallet if you don't have one already!",
                                                true)
                                .addField("$cash", "Gives you a random amount of Cash between 0 and 250!", true)
                                .addField("$gamble {your bet}",
                                                "50/50 Chance to win double the amount of your bet, or lose your bet entirely!",
                                                true)
                                .addField("$slots {your bet}",
                                                "Win 1.5 times your bet if 2 Reels match, Win 5 times your bet if all 3 Reels match, or lose your bet entirely if none of them match!",
                                                true)
                                .addField("$roll {your number} {your bet}",
                                                "Win double the amount of your bet if it hits the same color or lose your bet entirely",
                                                true)
                                .addField("$echo {your Message}", "Repeats your Message!", true)
                                .addField("$ping", "Pong", true)
                                .addField("$reverse {your Message}", "Repeats your Message, but in Reverse!", true)
                                .addField("$howgayis {a Name}", "Rates how Gay that Person is!", true)
                                .addField("jungs wohin", "Jungs, wohin gemma?", true)
                                .addField("jungs turnen", "Jungs, was machma in Turnen?", true)
                                .addField("Ratirl", "What does Anton do?", true)
                                .footer("AceOfSpades", "attachment://AceOfSpades.png").build();

                InputStream aceOfSpades = null;
                aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
                channel.createMessage(
                                MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                                                .addEmbed(embedPingMessage).build())
                                .block();
        }
}
