package engineeringthesis.androidrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.dto.TeacherDTO;
import engineeringthesis.androidrestapi.serviceImpl.TeacherServiceImpl;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/teachers")
public class TeacherController {

	@Autowired
	TeacherServiceImpl  teacherServiceImpl;
	
	
    @GetMapping
    List<TeacherDTO> getAllTeachers()
    {
		return teacherServiceImpl.getAllTeachers();
    }
    
    @GetMapping(value = "/{teacherId}")
    TeacherDTO getTeacherById(@PathVariable Integer teacherId )
    {
		return teacherServiceImpl.getOneById(teacherId);
		
    }
    
    @GetMapping(params = "languageName")
    List<TeacherDTO> getTeacherByLanguageName( @ApiParam(
    	    name =  "languageName",
    	    type = "String",
    	    value = "Name of language",
    	    example = "Angielski",
    	    required = false)@RequestParam(required = false, value = "languageName")  String languageName)
	    {
			return teacherServiceImpl.getTeachersByLanguageName(languageName);
	    }
   
    
    @PostMapping
    TeacherDTO saveTeacher(@RequestBody TeacherDTO teacherObj)
    {
    	return teacherServiceImpl.saveTeacher(teacherObj);
    }
    
    @PutMapping(value = "/{teacherId}")
    TeacherDTO updateTeacher(@RequestBody TeacherDTO teacherObj,
    					     @PathVariable Integer teacherId)
    {
    	return teacherServiceImpl.updateTeacher(teacherId,teacherObj);
    }
    
    @DeleteMapping(value = "/{teacherId}")
    void deleteTeacherById(@PathVariable Integer teacherId)
    {
    	teacherServiceImpl.deleteTeacher(teacherId);
    }
    
    
    @GetMapping(value = "/accounts")
    TeacherDTO getTeacherWithAccount( @ApiParam(
    	    name =  "accountName",
    	    type = "String",
    	    value = "account name",
    	    example = "admin",
    	    required = false)@RequestParam(required = true, value = "accountName")  String accountName)
	    {
			return teacherServiceImpl.getTeacherWithAccount(accountName);
	    }
}
