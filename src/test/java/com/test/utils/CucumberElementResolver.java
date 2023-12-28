package com.test.utils;

import lombok.NonNull;
import org.reflections.Reflections;
import org.reflections.ReflectionsException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CucumberElementResolver {

    private static final Reflections reflections = new Reflections("com.test.cucumberelements");

    private static final ThreadLocal<Map<String, CucumberElement>> elementMap = new ThreadLocal<>();

    public static CucumberElement resolveCucumberElement(@NonNull String elementName) {

        if (elementMap.get() == null) {
            fillElementMap();
        }

        CucumberElement element = elementMap.get().get(elementName);
        if (element != null) {
            return element;
        }

        throw new IllegalArgumentException("No CucumberElement with name '" + elementName + "' found");
    }

    private static void fillElementMap() {

        Map<String, CucumberElement> elementsMap = new HashMap<>();

        Set<Class<? extends CucumberElement>> allClasses = retrieveSelectorElementClasses();
        for (Class<? extends CucumberElement> selectorClass : allClasses) {
            CucumberElement[] enumConstants = selectorClass.getEnumConstants();
            if (enumConstants == null) {
                continue;
            }
            for (CucumberElement cucumberElement : enumConstants) {
                String elementName = cucumberElement.toString();
                if (elementsMap.containsKey(elementName)) {
                    throw new IllegalArgumentException("CucumberElement with name '" + elementName
                            + "' defined at least twice; one duplicate is in "
                            + selectorClass.getSimpleName());
                }
                elementsMap.put(elementName, cucumberElement);
            }
            elementMap.set(elementsMap);
        }
    }

    private static Set<Class<? extends CucumberElement>> retrieveSelectorElementClasses() {

        try {
            Set<Class<? extends CucumberElement>> classes = reflections.getSubTypesOf(CucumberElement.class);
            if (classes.isEmpty()) {
                throw new IllegalStateException("Project must have at least one CucumberElement enum");
            }
            return classes;
        } catch (ReflectionsException e) {
            return Set.of();
        }
    }
}