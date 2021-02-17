package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

	 RoleEntity findByRoleName(@Param("roleName")String roleName);
}
