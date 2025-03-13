package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot
{

    @Override
    public String getBotUsername()
    {
        return "WGTestBooking_bot";
    }

    @Override
    public String getBotToken()
    {
        return "7877544140:AAF1LVSgW7CTNyWAEDn8gQJqBJxCWcv9I74";
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        SendMessage sendMessage = new SendMessage();

        String botTextMessage;

        String chatId = update.getMessage().getChatId().toString();
        String userInput = update.getMessage().getText();

        switch(userInput)
        {
            case "Привет!":
                botTextMessage = "Приветствую Вас.";
                break;

            case "Забронировать столик.":
                botTextMessage = "Я еще маленький, я не умею...";
                break;

            default:
                botTextMessage = "Ваш запрос не обработан.";
                break;
        }

        sendMessage.setChatId(chatId);
        sendMessage.setText(botTextMessage);

        try
        {
            this.execute(sendMessage);
        }
        catch (TelegramApiException e)
        {
            throw new RuntimeException(e);
        }
    }
}
