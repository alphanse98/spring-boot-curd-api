package com.example.springbootcurdapi.repository;

import com.example.springbootcurdapi.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepo extends JpaRepository<CatalogEntity,Long> {
}
