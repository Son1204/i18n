package com.phraseapp.i18n.dynamiclanguage.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {
    @Autowired
    private DBMessageSource messageSource;

    public String getMessage(String message, String... dynamicValues) {
        return messageSource.getMessage(message, dynamicValues, LocaleContextHolder.getLocale());
    }

    public String getMessage(String message, Locale locale, String... dynamicValues) {
        return messageSource.getMessage(message, dynamicValues, locale);
    }
}
