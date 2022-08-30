package com.zerobase.fastlms.logHistory.repository;

import com.zerobase.fastlms.logHistory.entity.LogHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogHistoryRepository extends JpaRepository<LogHistory, String> {

    List<LogHistory> findAllByUserId(String userId);
}
