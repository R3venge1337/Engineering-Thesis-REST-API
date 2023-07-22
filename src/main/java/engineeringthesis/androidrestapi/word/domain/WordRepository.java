package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


interface WordRepository extends UUIDAwareJpaRepository<Word, Integer> {

    Page<Word> findAllByCategory_Name(final String name, final Pageable pageable);

    @Query("SELECT w FROM Word w WHERE w.name = :name")
    Word getWordByName(final String name);

}
