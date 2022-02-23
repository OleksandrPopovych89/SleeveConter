package telegram;

import Services.Calculate;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Bot extends TelegramLongPollingBot {


    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        final Document document = update.getMessage().getDocument();
        if (document != null) {
            final String fileId = document.getFileId();
            final String fileName = document.getFileName();

            System.out.println(fileId);
            System.out.println(fileName);
            String fileWay = uploadFile(fileName, fileId);
            String request = Calculate.calculate(fileWay);
            Message message = update.getMessage();
            execute(SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text(request)
                    .build());
        }
    }

    @Override
    public String getBotUsername() {
        return "@Sleevebot";
    }

    @Override
    public String getBotToken() {
        return "5255774293:AAGv9MyE7HNm1s3be_m8Jf6iF1X_tWo1j3w";
    }


    @SneakyThrows
    public static void main(String[] args) {
        Bot bot = new Bot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }

    @SneakyThrows
    public String uploadFile(String fileName, String fileId) {

        URL url = new URL("https://api.telegram.org/bot" + getBotToken() + "/getFile?file_id=" + fileId);
        System.out.println(url);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String getFileResponse = br.readLine();

        JSONObject jResult = new JSONObject(getFileResponse);
        JSONObject path = jResult.getJSONObject("result");
        String filePath = path.getString("file_path");
        System.out.println(filePath);

        File localFile = new File("src/main/resources/uploaded_files/" + fileName);
        InputStream is = new URL("https://api.telegram.org/file/bot" +
                getBotToken() + "/" + filePath).openStream();
        FileUtils.copyInputStreamToFile(is, localFile);

        br.close();
        is.close();

        System.out.println("Uploaded!");
        return localFile.toString();
    }
}