package org.example.tgcommons.model.wrapper;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.val;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

import static org.example.tgcommons.constant.Constant.Telegramm.PARSE_MODE;

@Getter
@SuperBuilder(setterPrefix = "set", builderMethodName = "init", toBuilder = true)
public class SendPhotoWrapper {

    private String chatIdString;
    private String caption;
    private Long chatIdLong;
    private InputFile photo;
    private InlineKeyboardMarkup inlineKeyboardMarkup;

    public SendPhoto createMessage() {
        val sendPhoto = new SendPhoto();
        val chatId = chatIdString == null ? String.valueOf(chatIdLong) : chatIdString;
        sendPhoto.setChatId(chatId);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        sendPhoto.setParseMode(PARSE_MODE);
        sendPhoto.setPhoto(photo);
        sendPhoto.setCaption(caption);
        return sendPhoto;
    }

    public List<PartialBotApiMethod> createMessageList() {
        return List.of(createMessage());
    }
}
