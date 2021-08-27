package com.deng.newOA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.newOA.entity.Process;

public interface ProcessDao extends JpaRepository<Process, Long> {

}
