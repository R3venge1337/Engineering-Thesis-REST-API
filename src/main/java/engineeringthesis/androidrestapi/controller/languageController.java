package engineeringthesis.androidrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.serviceImpl.languageServiceImpl;

@RestController
public class languageController {

	 @Autowired
	    private languageServiceImpl languageService;
}
