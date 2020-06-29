package engineeringthesis.androidrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.serviceImpl.categoryServiceImpl;


@RestController
public class categoryController {

    @Autowired
    private categoryServiceImpl categoryService;
}
