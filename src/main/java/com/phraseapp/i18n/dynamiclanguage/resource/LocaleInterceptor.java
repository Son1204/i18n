//package com.phraseapp.i18n.dynamiclanguage.resource;
//
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class LocaleInterceptor implements HandlerInterceptor {
//
//    @Resource
//    LocalHolder localHolder;
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//        if (localeResolver == null) {
//            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
//        }
//
//        if (localeResolver instanceof AcceptHeaderLocaleResolver headerLocaleResolver) {
//            localHolder.setCurrentLocale(headerLocaleResolver.resolveLocale(request));
//        } else {
//            throw new IllegalStateException("Resolver should be of AcceptHeaderLocaleResolver type");
//        }
//
//        return true;
//    }
//}