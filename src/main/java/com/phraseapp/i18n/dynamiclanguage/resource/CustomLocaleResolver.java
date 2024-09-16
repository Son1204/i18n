package com.phraseapp.i18n.dynamiclanguage.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {

    private static final String DEFAULT_LOCALE = Locale.ENGLISH.getLanguage();
//    private static final List<Locale> LOCALES = Arrays.asList(Locale.forLanguageTag("zh"), Locale.forLanguageTag("en"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (StringUtils.isEmpty(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE))) {
            return Locale.forLanguageTag(DEFAULT_LOCALE);
        }
        return Locale.forLanguageTag(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
//        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
//        return Locale.lookup(list, LOCALES);
    }
}
