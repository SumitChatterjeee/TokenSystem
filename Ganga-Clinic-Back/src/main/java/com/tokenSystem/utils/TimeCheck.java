package com.tokenSystem.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class TimeCheck {

    public boolean registrationPossible(LocalDateTime time) {

        LocalTime currentTime = time.toLocalTime();

        boolean morning =
                !currentTime.isBefore(LocalTime.of(8, 0))
                        && !currentTime.isAfter(LocalTime.of(14, 0));

        boolean evening =
                !currentTime.isBefore(LocalTime.of(16, 0))
                        && !currentTime.isAfter(LocalTime.of(22, 0));

        return morning || evening;
    }
}
