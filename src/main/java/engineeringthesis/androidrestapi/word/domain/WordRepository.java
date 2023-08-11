package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


interface WordRepository extends UUIDAwareJpaRepository<Word, Long>, JpaSpecificationExecutor<Word> {

    Page<Word> findAllByCategory_Name(final String name, final Pageable pageable);
}
