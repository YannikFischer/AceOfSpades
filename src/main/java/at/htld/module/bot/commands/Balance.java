package at.htld.module.bot.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

//import java.io.FileReader;
import java.util.HashMap;

//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;

public class Balance implements Command {
    // JSONParser parse = new JSONParser();
    // FileReader reader = new FileReader("balance.json");
    // Object obj = parse.parse(reader);
    // JSONArray balance = (JSONArray) obj;

    static int balance = 500;

    static HashMap<String, Integer> users = new HashMap<String, Integer>(); //

    @Override

    public void execute(Message message) {
        final MessageChannel channel = message.getChannel().block();

        channel.createMessage("```Your Balance: " + balance + "```").block();

        if (users.containsKey(message.getUserData().username())) {
            channel.createMessage("```Your Balance: " + balance + "```").block();
            channel.createMessage("```" + users + "```").block(); //
        } else {
            users.put(message.getUserData().username(), 500);
            channel.createMessage("```You dont have a Wallet yet!```").block();
        }
    }
}
