package jp.ac.ohara.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.schedule.model.ScheduleBook2;

@Repository
public interface ScheduleBookRepository2 extends JpaRepository<ScheduleBook2, Long> {
		
}
