package org.example.tgcommons.utils;

import lombok.val;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberConverter {

    public static final String LANGUAGE = "ru";
    public static final Locale locale = new Locale(LANGUAGE);

    private NumberConverter() {
    }

    public static String formatDouble(Double value) {
        val formatter = NumberFormat.getInstance(locale);
        return formatter.format(value);
    }
}
