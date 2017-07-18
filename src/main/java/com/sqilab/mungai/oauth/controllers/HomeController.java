package com.sqilab.mungai.oauth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mungai on 17/07/2017.
 */
@RestController
@RequestMapping("/api/home")
public class HomeController {
    @GetMapping
    public ResponseEntity<?> getHome(){
        ModelMap modelMap=new ModelMap();
        modelMap.put("message","Welcome");
        modelMap.put("status",true);
        return ResponseEntity.ok(modelMap);
    }

}
