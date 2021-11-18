package at.htld.module.bot;

import at.htld.module.bot.commands.Command;
import at.htld.module.bot.commands.Echo;
import at.htld.module.bot.commands.PingCommand;
import at.htld.module.bot.commands.Reverse;
import at.htld.module.bot.commands.Roulette;
import at.htld.module.bot.commands.Slots;
import at.htld.module.bot.commands.Balance;
import at.htld.module.bot.commands.Bet;
import at.htld.module.bot.commands.BlackJack;
import at.htld.module.bot.commands.Cash;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

public class DiscordBot {
    public static void main(String[] args) {
        String token = System.getProperty("DISCORD_TOKEN");// System.getProperty("DISCORD_TOKEN");
        if (token == null || token.length() == 0) {
            token = System.getenv("DISCORD_TOKEN");
            if (token == null || token.length() == 0) {
                System.err.println("Discord ist als Environment-Variable nicht gesetzt. Verwende "
                        + " -dDISCORD_TOKEN=${DEIN_TOKEN} oder -e DISCORD_TOKEN=${DEIN_TOKEN} bei Docker run");
                System.exit(1);
            }
        }

        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("$ping".equals(message.getContent())) {
                Command ping = new PingCommand();
                ping.execute(message);
            }
            if (message.getContent().contains("$echo")) {
                Command echo = new Echo();
                echo.execute(message);
            }
            if (message.getContent().contains("$reverse")) {
                Command reverse = new Reverse();
                reverse.execute(message);
            }
            if ("$bal".equals(message.getContent())) {
                Command balance = new Balance();
                balance.execute(message);
            }
            if ("$cash".equals(message.getContent())) {
                Command cash = new Cash();
                cash.execute(message);
            }
            if (message.getContent().contains("$slots")) {
                Command slots = new Slots();
                slots.execute(message);
            }
            if ("$bj".equals(message.getContent())) {
                Command blackJack = new BlackJack();
                blackJack.execute(message);
            }
            if (message.getContent().contains("$roll")) {
                Command roulette = new Roulette();
                roulette.execute(message);
            }
            if (message.getContent().contains("$bet")) {
                Command bet = new Bet();
                bet.execute(message);
            }
        });

        gateway.onDisconnect().block();
    }
}

// Fragen: Hashmap!!!
// Wie erstelle ich automatische Variablen (BlackJack)
// Abfragen ob eine Zahl mit dem Input übereinstimmt oder ob sie Gerade/Ungerade
// ist (Roulette)
// kompletter Bot crashed wenn catch ausgeführt wird (slots)
