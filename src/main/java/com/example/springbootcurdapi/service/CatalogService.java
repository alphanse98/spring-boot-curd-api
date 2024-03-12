package com.example.springbootcurdapi.service;

import com.example.springbootcurdapi.entity.CatalogEntity;

import java.util.List;

public interface CatalogService {
    List<CatalogEntity> getAllProduct();

    CatalogEntity createProduct(CatalogEntity CatalogEntity);
}
