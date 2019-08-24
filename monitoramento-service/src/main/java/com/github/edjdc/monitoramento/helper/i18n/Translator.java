package com.github.edjdc.monitoramento.helper.i18n;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Translator {

	private final ResourceBundleMessageSource messageSource;

	public String get(String message) {
		return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
	}
	
	public String get(String message, Object ...args) {
		return messageSource.getMessage(message, args, LocaleContextHolder.getLocale());
	}
	
}
