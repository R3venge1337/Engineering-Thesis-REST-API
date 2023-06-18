package engineeringthesis.androidrestapi.word.domain;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface WordRepository extends JpaRepository<Word,Integer> {
	
	
	 Page<Word> findAllByCategoryId_CategoryName(String categoryName, Pageable pageable);
	 
	 @Query("SELECT w FROM WordEntity w WHERE w.wordName = :wordName")
	 Word getWordByName(@Param("wordName") String wordName);
	  
}
