package org.example.tgcommons.model.wrapper;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.val;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

import java.util.List;

import static org.example.tgcommons.constant.Constant.Telegramm.PARSE_MODE;

@Getter
@SuperBuilder(setterPrefix = "set", builderMethodName = "init", toBuilder = true)
public class EditMessageTextWrap {

    private Integer messageId;
    private String chatIdString;
    private Long chatIdLong;
    private String text;

    public PartialBotApiMethod createMessage() {
        val editMessageText = new EditMessageText();
        editMessageText.setMessageId(messageId);
        val chatId = chatIdString == null ? String.valueOf(chatIdLong) : chatIdString;
        editMessageText.setChatId(chatId);
        editMessageText.setText(text);
        editMessageText.setParseMode(PARSE_MODE);
        return editMessageText;
    }

    public List<PartialBotApiMethod> createMessageList() {
        return List.of(createMessage());
    }
}
