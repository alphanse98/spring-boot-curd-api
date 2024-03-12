package com.example.springbootcurdapi.service.impl;

import com.example.springbootcurdapi.entity.CatalogEntity;
import com.example.springbootcurdapi.repository.CatalogRepo;
import com.example.springbootcurdapi.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepo catalogRepo;

    @Override
    public List<CatalogEntity> getAllProduct(){
        return catalogRepo.findAll();
    }



    @Override
    public  CatalogEntity createProduct(CatalogEntity  CatalogEntity){
        return catalogRepo.save(CatalogEntity);
    }

}



