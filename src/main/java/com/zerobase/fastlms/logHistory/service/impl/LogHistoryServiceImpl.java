package com.zerobase.fastlms.logHistory.service.impl;

import com.zerobase.fastlms.logHistory.LogHistoryDto;
import com.zerobase.fastlms.logHistory.entity.LogHistory;
import com.zerobase.fastlms.logHistory.repository.LogHistoryRepository;
import com.zerobase.fastlms.logHistory.service.LogHistoryService;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LogHistoryServiceImpl implements LogHistoryService {

    private final LogHistoryRepository logHistoryRepository;

    @Override

    public void add(Member member, HttpServletRequest request) {
        logHistoryRepository.save(
                LogHistory.builder()
                        .userId(member.getUserId())
                        .userAgent(RequestUtils.getUserAgent(request))
                        .loggedInTime(LocalDateTime.now())
                        .Ip(RequestUtils.getClientIP(request))
                        .build()
        );

    }

    @Override
    public List<LogHistoryDto> list(String memberId) {
        List<LogHistory> logHistories = logHistoryRepository.findAllByUserId(memberId);
        List<LogHistoryDto> logHistoryDtoList = new ArrayList<>();

        logHistories.forEach(x -> logHistoryDtoList.add(
                LogHistoryDto.of(x)
        ));

        log.info(logHistoryDtoList.toString());
        return logHistoryDtoList;
    }
}