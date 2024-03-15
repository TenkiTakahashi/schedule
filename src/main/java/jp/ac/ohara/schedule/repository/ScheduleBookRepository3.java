package jp.ac.ohara.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.schedule.model.ScheduleBook3;

@Repository
public interface ScheduleBookRepository3 extends JpaRepository<ScheduleBook3, Long> {
	
}
