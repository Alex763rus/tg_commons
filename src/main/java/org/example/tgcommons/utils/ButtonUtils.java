package org.example.tgcommons.utils;

import lombok.val;
import org.example.tgcommons.model.button.ButtonsDescription;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class ButtonUtils {

    public static InlineKeyboardMarkup createVerticalColumnMenu(final ButtonsDescription buttonsDescription) {
        val inlineKeyboardMarkup = new InlineKeyboardMarkup();
        val rows = new ArrayList<List<InlineKeyboardButton>>();

        int indexMenu = 1;
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        val buttons = buttonsDescription.getButtons();
        for (val button : buttons) {
            val btn = new InlineKeyboardButton();
            btn.setCallbackData(button.getKey());
            btn.setText(button.getValue());
            if (button.getLink() != null) {
                btn.setUrl(button.getLink());
            }
            rowInline.add(btn);
            if (indexMenu % buttonsDescription.getCountColumn() == 0) {
                rows.add(rowInline);
                rowInline = new ArrayList<>();
            }
            ++indexMenu;
        }
        rows.add(rowInline);
        inlineKeyboardMarkup.setKeyboard(rows);
        return inlineKeyboardMarkup;
    }
}
