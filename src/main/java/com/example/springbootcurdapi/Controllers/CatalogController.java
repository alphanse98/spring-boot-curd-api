package com.example.springbootcurdapi.Controllers;
import com.example.springbootcurdapi.entity.CatalogEntity;
import com.example.springbootcurdapi.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "*",
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@AllArgsConstructor
@RestController
public class CatalogController {



    private CatalogService CatalogService;
    @GetMapping("/get/catalog")
    public ResponseEntity<List<CatalogEntity>> getData(){
        List<CatalogEntity> res = CatalogService.getAllProduct();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create/catalog")
    public ResponseEntity<CatalogEntity> newProduct( @RequestBody CatalogEntity CatalogEntity){
        System.out.print("CatalogEntity " + CatalogEntity);
        CatalogEntity res = CatalogService.createProduct(CatalogEntity);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
//        return  null ;
    }

}
