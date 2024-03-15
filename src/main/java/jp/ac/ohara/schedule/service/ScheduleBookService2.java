package jp.ac.ohara.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.ScheduleBook2;
import jp.ac.ohara.schedule.repository.ScheduleBookRepository2;

@Service
@Transactional
public class ScheduleBookService2 {

	@Autowired
	private ScheduleBookRepository2 repository;

	/**
	 * スケジュール帳一覧の取得
	 * @return List<ScheduleBook2>
	 */
	public List<ScheduleBook2> getScheduleList() {
	    List<ScheduleBook2> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  ScheduleBook2
	 */
	public ScheduleBook2 get(@NonNull Long index) {
		ScheduleBook2 scheduleBook2 = this.repository.findById(index).orElse(new ScheduleBook2());
		return scheduleBook2;
	}

	/**
	 * スケジュール帳一覧の取得
	 * @param ScheduleBook2 scheduleBook2
	 */
	public void save(@NonNull ScheduleBook2 scheduleBook2) {
		this.repository.save(scheduleBook2);
	}

	/**
	 * スケジュール帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
