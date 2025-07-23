package com.snow.blog.controller;

import com.snow.blog.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;
}
