package org.example.tgcommons.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Constant {

    @NoArgsConstructor(access = PRIVATE)
    public final class Command {
        public static final String COMMAND_DEFAULT = "/default";
        public static final String COMMAND_START = "/start";
    }

    @NoArgsConstructor(access = PRIVATE)
    public final class FileOperation {
        public static final String FILE_STORAGE_URI = "https://api.telegram.org/file/bot{bot.token}/{filePath}";
        public static final String FILE_INFO_URI = "https://api.telegram.org/bot{bot.token}/getFile?file_id={fileId}";
    }
    @NoArgsConstructor(access = PRIVATE)
    public final class TextConstants {
        public static final String SHIELD = "\\";
        public static final String EMPTY = "";

        public static final String STAR = "*";

        public static String NEW_LINE = "\n";
        public static String SPACE = " ";
    }

    @NoArgsConstructor(access = PRIVATE)
    public final class Telegramm {
        public static String PARSE_MODE = "Markdown";
    }

}
