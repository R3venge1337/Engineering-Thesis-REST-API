package engineeringthesis.androidrestapi.child.controller;

import java.util.List;

import engineeringthesis.androidrestapi.child.ChildFacade;
import engineeringthesis.androidrestapi.child.dto.ChildDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/children")
@RequiredArgsConstructor
class ChildController {

	private final ChildFacade childFacade;

	@GetMapping
	List<ChildDTO> getAllChildren() {
		return childFacade.getAllChild();
	}

	@GetMapping("/{childId}")
	ChildDTO getChildById(@PathVariable Integer childId) {
		return childFacade.getOneById(childId);
	}

	@PostMapping
	ChildDTO saveChild(@RequestBody ChildDTO childObj) {
		return childFacade.saveChild(childObj);
	}

	@PutMapping("/{childId}")
	ChildDTO updateChild(@RequestBody ChildDTO childObj, @PathVariable Integer childId) {
		return childFacade.updateChild(childId, childObj);
	}

	@DeleteMapping("/{childId}")
	void deleteChild(@PathVariable Integer childId) {
		childFacade.deleteChild(childId);
	}

	@GetMapping("/accounts")
	ChildDTO getChildWithAccount(@RequestParam(required = true, value = "accountName") String accountName) {
		return childFacade.getChildWithAccount(accountName);
	}
}
