package com.school.admin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.admin.api.entities.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer>{}
