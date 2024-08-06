package com.example.translationservice.repository;

import com.example.translationservice.model.TranslationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRequestRepository extends JpaRepository<TranslationRequest, Long> {
}
