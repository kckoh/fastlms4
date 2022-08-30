package com.zerobase.fastlms.logHistory.service;

import com.zerobase.fastlms.logHistory.LogHistoryDto;
import com.zerobase.fastlms.member.entity.Member;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LogHistoryService {
    void add(Member member, HttpServletRequest request);

    List<LogHistoryDto> list(String memberId);

}
