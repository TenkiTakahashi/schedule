package jp.ac.ohara.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.ScheduleBook3;
import jp.ac.ohara.schedule.repository.ScheduleBookRepository3;

@Service
@Transactional
public class ScheduleBookService3 {

	@Autowired
	private ScheduleBookRepository3 repository;

	/**
	 * スケジュール帳一覧の取得
	 * @return List<ScheduleBook3>
	 */
	public List<ScheduleBook3> getScheduleList() {
	    List<ScheduleBook3> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  ScheduleBook3
	 */
	public ScheduleBook3 get(@NonNull Long index) {
		ScheduleBook3 scheduleBook3 = this.repository.findById(index).orElse(new ScheduleBook3());
		return scheduleBook3;
	}

	/**
	 * スケジュール帳一覧の取得
	 * @param ScheduleBook3 scheduleBook3
	 */
	public void save(@NonNull ScheduleBook3 scheduleBook3) {
		this.repository.save(scheduleBook3);
	}

	/**
	 * スケジュール帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
