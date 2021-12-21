package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;

import java.io.InputStream;
//import java.io.FileReader;
import java.util.HashMap;

//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;

public class Balance implements Command {
    static HashMap<String, Integer> users = new HashMap<String, Integer>();

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        InputStream aceOfSpades = null;
        aceOfSpades = ClassLoader.getSystemResourceAsStream("AceOfSpades.png");
        InputStream coinImage = null;
        coinImage = ClassLoader.getSystemResourceAsStream("CoinImage.png");

        if (!users.containsKey(message.getUserData().username())) {
            users.put(message.getUserData().username(), 500);
        }

        String balanceString = Integer.toString(Balance.users.get(message.getUserData().username()));

        EmbedCreateSpec embedBalance = EmbedCreateSpec.builder().color(Color.YELLOW).title("Your Balance :")
                .author("Balance", "https://github.com/YannikFischer/AceOfSpades", "attachment://CoinImage.png")
                .description(balanceString).footer("AceOfSpades", "attachment://AceOfSpades.png").build();

        if (users.containsKey(message.getUserData().username())) {
            channel.createMessage(MessageCreateSpec.builder().addFile("AceOfSpades.png", aceOfSpades)
                    .addFile("CoinImage.png", coinImage).addEmbed(embedBalance).build()).block();
        }
    }
}
