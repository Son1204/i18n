package com.phraseapp.i18n.dynamiclanguage.resource;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import com.phraseapp.i18n.dynamiclanguage.entity.LanguageEntity;
import com.phraseapp.i18n.dynamiclanguage.repository.LanguageRepository;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

	@Autowired
	private LanguageRepository languageRepository;
	
	private static final String DEFAULT_LOCALE_CODE = "en";

	@Override
	protected MessageFormat resolveCode(String key, Locale locale) {
		LanguageEntity message = languageRepository.findByKeyAndLocale(key,locale.getLanguage());
		if (message == null) {
			message = languageRepository.findByKeyAndLocale(key,DEFAULT_LOCALE_CODE);
		}
		return new MessageFormat(message.getContent(), locale);
	}

	public static void main(String[] args) {
		Map<String, Object> valuesMap = new HashMap<>();
		valuesMap.put("animal", "quick brown fox");
		valuesMap.put("target", 1);
		String templateString = "The #{animal} jumped over the #{target}.";
		StringSubstitutor sub = new StringSubstitutor(valuesMap, "#{", "}");
		String resolvedString = sub.replace(templateString);
		System.out.println(resolvedString);
	}

}
