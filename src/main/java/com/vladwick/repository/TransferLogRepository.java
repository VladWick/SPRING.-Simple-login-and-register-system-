package com.vladwick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vladwick.model.TransferLog;

@Repository
public interface TransferLogRepository extends JpaRepository<TransferLog, Long> {

}
