package com.smartwaste.security;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttemptService {

    private final int MAX_ATTEMPT = 5;
    private final long BLOCK_DURATION_MS = TimeUnit.MINUTES.toMillis(15);
    
    // IP address / Email -> Attempt Details
    private final ConcurrentHashMap<String, AttemptDetails> attemptsCache = new ConcurrentHashMap<>();

    public void loginSucceeded(String key) {
        attemptsCache.remove(key);
    }

    public void loginFailed(String key) {
        AttemptDetails details = attemptsCache.getOrDefault(key, new AttemptDetails(0, System.currentTimeMillis()));
        
        // Reset if block duration has passed
        if (System.currentTimeMillis() - details.lastAttemptTime > BLOCK_DURATION_MS) {
            details.attempts = 0;
        }
        
        details.attempts++;
        details.lastAttemptTime = System.currentTimeMillis();
        attemptsCache.put(key, details);
    }

    public boolean isBlocked(String key) {
        AttemptDetails details = attemptsCache.get(key);
        if (details != null) {
            if (details.attempts >= MAX_ATTEMPT && System.currentTimeMillis() - details.lastAttemptTime < BLOCK_DURATION_MS) {
                return true;
            } else if (System.currentTimeMillis() - details.lastAttemptTime >= BLOCK_DURATION_MS) {
                attemptsCache.remove(key); // clear expired
            }
        }
        return false;
    }

    private static class AttemptDetails {
        int attempts;
        long lastAttemptTime;

        AttemptDetails(int attempts, long lastAttemptTime) {
            this.attempts = attempts;
            this.lastAttemptTime = lastAttemptTime;
        }
    }
}
