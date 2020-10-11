package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.StatisticTypeEntity;

@Repository
public interface StatisticTypeRepository  extends JpaRepository<StatisticTypeEntity,Integer>{

}
