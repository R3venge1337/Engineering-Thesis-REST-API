package engineeringthesis.androidrestapi.child.controller;

import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.child.ChildFacade;
import engineeringthesis.androidrestapi.child.dto.ChildDto;
import engineeringthesis.androidrestapi.child.dto.CreateChildForm;
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
	List<ChildDto> getAllChildren() {
		return childFacade.getAllChild();
	}

	@PostMapping
    ChildDto saveChild(@RequestBody final CreateChildForm childForm) {
		return childFacade.saveChild(childForm);
	}

	@PutMapping("/{uuid}")
    ChildDto updateChild(@PathVariable final UUID uuid, @RequestBody final CreateChildForm childForm) {
		return childFacade.updateChild(uuid, childForm);
	}

	@DeleteMapping("/{uuid}")
	void deleteChild(@PathVariable final UUID uuid) {
		childFacade.deleteChild(uuid);
	}

	@GetMapping("/{uuid}/accounts")
    ChildDto getChildWithAccount(@PathVariable final UUID uuid, @RequestParam final String accountName) {
		return childFacade.getChildWithAccount(uuid, accountName);
	}
}
