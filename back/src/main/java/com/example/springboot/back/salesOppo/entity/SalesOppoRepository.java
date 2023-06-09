package com.example.springboot.back.salesOppo.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOppoRepository extends JpaRepository<SalesOppo, String> {
    Page<SalesOppo> findByEmpnoContaining(String empSearch,Pageable pageable);
}