package engineeringthesis.androidrestapi.child;

import engineeringthesis.androidrestapi.child.dto.*;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;

import java.util.UUID;


public interface ChildFacade {

    PageDto<ChildDto> findChildren(final ChildFilterForm filterForm, final PageableRequest pageableRequest);

    ChildDto findChild(final UUID uuid);

    UuidDto saveChild(final CreateChildForm createForm);

    void updateChild(final UUID uuid, final UpdateChildForm updateForm);

    void deleteChild(final UUID uuid);

    ChildWithAccountDto findChildWithAccount(final UUID uuid, final String accountName);
}
