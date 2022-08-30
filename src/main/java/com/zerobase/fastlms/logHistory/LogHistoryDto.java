package com.zerobase.fastlms.logHistory;

import com.zerobase.fastlms.logHistory.entity.LogHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LogHistoryDto {
    private Long id;
    private LocalDateTime loggedInTime;
    private String ip;
    private String userAgent;

    public static LogHistoryDto of(LogHistory logHistory) {
        return LogHistoryDto.builder()
                .id(logHistory.getId())
                .loggedInTime(logHistory.getLoggedInTime())
                .ip(logHistory.getIp())
                .userAgent(logHistory.getUserAgent())
                .build();
    }
}
