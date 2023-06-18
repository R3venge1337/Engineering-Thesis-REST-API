package engineeringthesis.androidrestapi.teacher.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface TeacherRepository  extends JpaRepository<Teacher,Integer>{
	
	@Query("SELECT t FROM TeacherEntity t INNER JOIN LanguageEntity l ON t.languageTeacherId = l.languageId WHERE l.languageName = :languageName ")
	List<Teacher> getTeachersByLanguageName(@Param("languageName") String languageName);
	
	@Query("SELECT t FROM TeacherEntity t INNER JOIN AccountEntity acc ON t.accountTeacherId = acc.accountId WHERE acc.accountName = :accountName ")
	Teacher getTeacherWithAccount(@Param("accountName") String accountName);
}
