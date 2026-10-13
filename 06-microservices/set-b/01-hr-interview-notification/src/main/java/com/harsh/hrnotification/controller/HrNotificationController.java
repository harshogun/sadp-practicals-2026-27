package com.harsh.hrnotification.controller;

import com.harsh.hrnotification.dto.CandidateRequest;
import com.harsh.hrnotification.model.InterviewNotification;
import com.harsh.hrnotification.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hr/notifications")
public class HrNotificationController {

    private final NotificationService notificationService;

    public HrNotificationController(
            NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/interview-selection")
    @ResponseStatus(HttpStatus.CREATED)
    public InterviewNotification notifyCandidate(
            @Valid @RequestBody CandidateRequest request) {

        return notificationService.notifyCandidate(request);
    }

    @GetMapping
    public List<InterviewNotification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}