package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.child;
import engineeringthesis.androidrestapi.serviceImpl.childServiceImpl;


@RestController
public class childController {
	 @Autowired
	    private childServiceImpl childServiceImpl;
	 
	//@GetMapping
	    @RequestMapping(value="/children",method = RequestMethod.GET)
	    List<child> getAllChildren()
	    {
			return childServiceImpl.getAllChild();
	    }
	    
	    
	   // @GetMapping
	    @RequestMapping(value="/child/{id}",method = RequestMethod.GET)
	    Optional<child> getChildById(@PathVariable Integer childId )
	    {
			return childServiceImpl.getOneById(childId);
	    }
	    
	   // @PostMapping
	    @RequestMapping(value="/child",method =  RequestMethod.POST)
	    child saveChild(@ModelAttribute child childObj)
	    {
	    	return childServiceImpl.saveChild(childObj);
	    }
	    //@PutMapping
	    @RequestMapping(value="/child",method = RequestMethod.PUT)
	    child updateChild(@ModelAttribute child childObj)
	    {
	    	return childServiceImpl.saveChild(childObj);
	    }
	    //@DeleteMapping
	    @RequestMapping(value="/child/{id}",method= RequestMethod.DELETE)
	    void deleteChild(@PathVariable Integer childId)
	    {
	    	childServiceImpl.deleteChild(childId);
	    }
}
