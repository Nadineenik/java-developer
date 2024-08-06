package com.example.translationservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class TranslationService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public TranslationService(RestTemplate restTemplate) {
    }

    public List<String> translateWords(List<String> words, String sourceLang, String targetLang) throws InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        for (String word : words) {
            futures.add(executorService.submit(() -> translateWord(word, sourceLang, targetLang)));
        }

        List<String> translatedWords = new ArrayList<>();
        for (Future<String> future : futures) {
            try {
                translatedWords.add(future.get());
            } catch (ExecutionException e) {
                translatedWords.add("Ошибка перевода");
            }
        }
        return translatedWords;
    }

    private String translateWord(String word, String sourceLang, String targetLang) {
        // Вызов внешнего API для перевода
        // Здесь нужно реализовать вызов внешнего API
        return word; // временный возврат слова без перевода
    }
}
