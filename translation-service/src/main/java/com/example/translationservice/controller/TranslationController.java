package com.example.translationservice.controller;

import com.example.translationservice.model.TranslationRequest;
import com.example.translationservice.repository.TranslationRequestRepository;
import com.example.translationservice.service.TranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/translate")
public class TranslationController {

    private final TranslationService translationService;
    private final TranslationRequestRepository translationRequestRepository;

    public TranslationController(TranslationService translationService, TranslationRequestRepository translationRequestRepository) {
        this.translationService = translationService;
        this.translationRequestRepository = translationRequestRepository;
    }

    @PostMapping
    public ResponseEntity<String> translate(@RequestParam String sourceLang,
                                            @RequestParam String targetLang,
                                            @RequestBody String inputText,
                                            HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        List<String> words = Arrays.asList(inputText.split("\\s+"));
        try {
            List<String> translatedWords = translationService.translateWords(words, sourceLang, targetLang);
            String translatedText = String.join(" ", translatedWords);

            TranslationRequest translationRequest = new TranslationRequest();
            translationRequest.setIpAddress(ipAddress);
            translationRequest.setInputText(inputText);
            translationRequest.setTranslatedText(translatedText);
            translationRequestRepository.save(translationRequest);

            return ResponseEntity.ok(translatedText);
        } catch (InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка выполнения запроса");
        }
    }
}
