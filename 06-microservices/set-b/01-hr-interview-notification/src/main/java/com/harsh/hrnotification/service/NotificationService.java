package com.harsh.hrnotification.service;

import com.harsh.hrnotification.dto.CandidateRequest;
import com.harsh.hrnotification.model.InterviewNotification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NotificationService {

    private static final String INTERVIEW_MESSAGE =
            "You have been selected for an interview";

    private final Map<Long, InterviewNotification> notifications =
            new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    public InterviewNotification notifyCandidate(
            CandidateRequest request) {

        InterviewNotification notification =
                new InterviewNotification(
                        idGenerator.incrementAndGet(),
                        request.candidateName().trim(),
                        request.email().trim(),
                        INTERVIEW_MESSAGE,
                        LocalDateTime.now()
                );

        notifications.put(notification.getId(), notification);

        return notification;
    }

    public List<InterviewNotification> getAllNotifications() {
        return notifications.values()
                .stream()
                .sorted(Comparator.comparing(
                        InterviewNotification::getId))
                .toList();
    }
}