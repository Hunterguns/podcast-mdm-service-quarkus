package org.sandeep.utils;

import java.time.Duration;

public class ApplicationUtils {

    public static String formatDuration(int seconds){
        Duration duration = Duration.ofSeconds(seconds);
        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes(), duration.toSeconds());
    }
}
