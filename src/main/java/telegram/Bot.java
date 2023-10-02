package telegram;

import lombok.NoArgsConstructor;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import services.Calculate;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {
    public Bot(DefaultBotOptions options, String botToken) {
        super(options, botToken);
    }

    public void onUpdateReceived(Update update) {
        final Document document = update.getMessage().getDocument();
        if (document != null) {
            final String fileId = document.getFileId();
            final String fileName = document.getFileName();

            System.out.println(fileId);
            System.out.println(fileName);

            String fileWay = uploadFile(fileName, fileId);
            String request = Calculate.calculate(fileWay);

            int messageLengthLimit = 4096;
            int totalLength = request.length();
            int numberOfMessages = (int) Math.ceil((double) totalLength / messageLengthLimit);

            for (int i = 0; i < numberOfMessages; i++) {
                int startIndex = i * messageLengthLimit;
                int endIndex = Math.min((i + 1) * messageLengthLimit, totalLength);

                String messagePart = request.substring(startIndex, endIndex);

                try {
                    execute(SendMessage.builder()
                            .chatId(update.getMessage().getChatId().toString())
                            .text(messagePart)
                            .build());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public String getBotUsername() {
        return "@SleeveBot";
    }

    @Override
    public String getBotToken() {
        return "5255774293:AAGO_ldCdk52VlG4H6aGmKILzQGYW83LV1w";
    }

    public String uploadFile(String fileName, String fileId) {

        URL url = null;
        try {
            url = new URL("https://api.telegram.org/bot" + getBotToken() + "/getFile?file_id=" + fileId);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(url);

        BufferedReader br = null;
        try {
            assert url != null;
            br = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String getFileResponse = null;
        try {
            assert br != null;
            getFileResponse = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert getFileResponse != null;
        JSONObject jResult = new JSONObject(getFileResponse);
        JSONObject path = jResult.getJSONObject("result");
        String filePath = path.getString("file_path");
        System.out.println(filePath);

        File localFile = new File("src/main/resources/uploaded_files/" + fileName);
        InputStream is = null;
        try {
            is = new URL("https://api.telegram.org/file/bot" +
                    getBotToken() + "/" + filePath).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert is != null;
            FileUtils.copyInputStreamToFile(is, localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Uploaded!");
        return localFile.toString();
    }
}