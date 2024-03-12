package com.example.springbootcurdapi.Controllers;


import com.example.springbootcurdapi.entity.CatalogEntity;
import com.example.springbootcurdapi.service.CatalogService;
import com.example.springbootcurdapi.service.impl.CatalogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CatalogController {



    private CatalogService CatalogService;
    @GetMapping("/get")
    public ResponseEntity<List<CatalogEntity>> getData(){
        List<CatalogEntity> res = CatalogService.getAllProduct();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CatalogEntity> newProduct( @RequestBody CatalogEntity CatalogEntity){
        CatalogEntity res = CatalogService.createProduct(CatalogEntity);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

}
