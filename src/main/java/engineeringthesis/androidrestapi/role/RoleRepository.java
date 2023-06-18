package engineeringthesis.androidrestapi.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

	 RoleEntity findByRoleName(@Param("roleName")String roleName);
}
