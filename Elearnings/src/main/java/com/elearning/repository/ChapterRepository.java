package com.elearning.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.elearning.model.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

	@Query("select  c from Chapter c where c.course.courseId=:courseId")
	List<Chapter> findByCourseWiseId(@Param("courseId") long courseId);

}

