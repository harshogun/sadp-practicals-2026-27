package com.harsh.hrnotification.model;

import java.time.LocalDateTime;

public class InterviewNotification {

    private Long id;
    private String candidateName;
    private String email;
    private String message;
    private LocalDateTime createdAt;

    public InterviewNotification() {
    }

    public InterviewNotification(
            Long id,
            String candidateName,
            String email,
            String message,
            LocalDateTime createdAt) {
        this.id = id;
        this.candidateName = candidateName;
        this.email = email;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}