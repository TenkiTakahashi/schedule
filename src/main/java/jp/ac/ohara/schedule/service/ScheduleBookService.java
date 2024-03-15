package jp.ac.ohara.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.ScheduleBook;
import jp.ac.ohara.schedule.repository.ScheduleBookRepository;

@Service
@Transactional
public class ScheduleBookService {

	@Autowired
	private ScheduleBookRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * スケジュール帳一覧の取得
	 * @return List<ScheduleBook>
	 */
	public List<ScheduleBook> getScheduleList() {
	    List<ScheduleBook> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  ScheduleBook
	 */
	public ScheduleBook get(@NonNull Long index) {
		ScheduleBook scheduleBook = this.repository.findById(index).orElse(new ScheduleBook());
		return scheduleBook;
	}

	/**
	 * スケジュール帳一覧の取得
	 * @param ScheduleBook scheduleBook
	 */
	public void save(@NonNull ScheduleBook schedule) {
		schedule.setPassword(this.passwordEncoder.encode(schedule.getPassword()));
		this.repository.save(schedule);
	}

	/**
	 * スケジュール帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
