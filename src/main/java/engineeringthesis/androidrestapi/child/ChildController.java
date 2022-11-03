package engineeringthesis.androidrestapi.child;

import java.util.List;
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

	private final ChildServiceImpl childServiceImpl;

	@GetMapping
	List<ChildDTO> getAllChildren() {
		return childServiceImpl.getAllChild();
	}

	@GetMapping("/{childId}")
	ChildDTO getChildById(@PathVariable Integer childId) {
		return childServiceImpl.getOneById(childId);
	}

	@PostMapping
	ChildDTO saveChild(@RequestBody ChildDTO childObj) {
		return childServiceImpl.saveChild(childObj);
	}

	@PutMapping("/{childId}")
	ChildDTO updateChild(@RequestBody ChildDTO childObj, @PathVariable Integer childId) {
		return childServiceImpl.updateChild(childId, childObj);
	}

	@DeleteMapping("/{childId}")
	void deleteChild(@PathVariable Integer childId) {
		childServiceImpl.deleteChild(childId);
	}

	@GetMapping("/accounts")
	ChildDTO getChildWithAccount(@RequestParam(required = true, value = "accountName") String accountName) {
		return childServiceImpl.getChildWithAccount(accountName);
	}
}
