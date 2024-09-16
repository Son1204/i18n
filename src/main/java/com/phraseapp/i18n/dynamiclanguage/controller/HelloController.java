package com.phraseapp.i18n.dynamiclanguage.controller;

import com.phraseapp.i18n.dynamiclanguage.resource.DBMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    DBMessageSource messageSource;

    @GetMapping(value = "/test")
    public String hello() {
        System.out.println(LocaleContextHolder.getLocale());
        return messageSource.getMessage("home.info", null, LocaleContextHolder.getLocale());
    }
}