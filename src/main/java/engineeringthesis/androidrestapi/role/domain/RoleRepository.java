package engineeringthesis.androidrestapi.role.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface RoleRepository extends JpaRepository<Role,Integer> {

	 Role findByRoleName(@Param("roleName")String roleName);
}
