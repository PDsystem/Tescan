package com.example.springboot.back.salesOppo.web;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.back.salesOppo.entity.SalesOppo;
import com.example.springboot.back.salesOppo.web.dtos.SalesOppoDto;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class SalesOppoController {
    private final SalesOppoService salesOppoService;

    // 목록 조회하기
    @PostMapping("/Oppo/list")
    public Page<SalesOppo> salesOppoList(Model model,Pageable pageable,@RequestBody Map<String,Object> params) { 

        int page=0;
        if(params.get("page")!=null){
            page=(int) params.get("page");
        }
         
        String empSearch=(String) params.get("empSearch");

         Page<SalesOppo> list =null;
         if(empSearch ==null){
             list=salesOppoService.getSalesOppoList(pageable,page);
         }else{
             list=salesOppoService.salesOppoSearchList(empSearch, pageable,page);
         }       
        return list; 
    }

    @PostMapping("/oppo/insert")
    public String create(@RequestBody SalesOppoDto salesOppoDto) {
        // String result= codeMasterService.codemax();
        // System.out.println(result);
        // System.out.println(codeMasterDto.getClass_code());
        salesOppoDto.setEmpno(salesOppoDto.getEmpno());
        System.out.println(salesOppoDto);
        salesOppoService.create(salesOppoDto);
        return null;
    }

    @DeleteMapping("/salesOppoDelete/{id}")
    public int salesOppoDelete(@PathVariable String id){
        System.out.println(id);
        int result=salesOppoService.salesOppoDelete(id);
        return result;
    }
}