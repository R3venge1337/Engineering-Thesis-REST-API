package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.teacher;
import engineeringthesis.androidrestapi.serviceImpl.teacherServiceImpl;

@RestController
public class teacherController {

	@Autowired
	teacherServiceImpl  teacherServiceImpl;
	
	
    //@GetMapping
    @RequestMapping(value = {"/teachers"}, method = RequestMethod.GET)
    List<teacher> getAllTeachers()
    {
		return teacherServiceImpl.getAllTeachers();
    }
    
    //@GetMapping
    @RequestMapping(value="/teacher/{teacherId}",method=RequestMethod.GET)
    Optional<teacher> getTeacherById(@PathVariable Integer teacherId )
    {
		return teacherServiceImpl.getOneById(teacherId);
    }
    //@PostMapping
    @RequestMapping(value="/teacher",method = RequestMethod.POST)
    teacher saveTeacher(@ModelAttribute teacher teacherObj)
    {
    	return teacherServiceImpl.saveTeacher(teacherObj);
    }
    @PutMapping
    @RequestMapping(value="/teacher",method = RequestMethod.PUT)
    teacher updateTeacher(@ModelAttribute teacher teacherObj)
    {
    	return teacherServiceImpl.saveTeacher(teacherObj);
    }
    @DeleteMapping
    @RequestMapping(value="/teacher/{teacherId}",method= RequestMethod.DELETE)
    void deleteTeacherById(@PathVariable Integer teacherId)
    {
    	teacherServiceImpl.deleteTeacher(teacherId);
    }
}
