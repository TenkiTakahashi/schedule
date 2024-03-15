package jp.ac.ohara.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.schedule.model.ScheduleBook;
import jp.ac.ohara.schedule.model.ScheduleBook2;
import jp.ac.ohara.schedule.model.ScheduleBook3;
import jp.ac.ohara.schedule.service.ScheduleBookService;
import jp.ac.ohara.schedule.service.ScheduleBookService2;
import jp.ac.ohara.schedule.service.ScheduleBookService3;


@Controller
public class ScheduleController {
	@Autowired
	private ScheduleBookService scheduleBookService;
	@Autowired
	private ScheduleBookService2 scheduleBookService2;
	@Autowired
	private ScheduleBookService3 scheduleBookService3;
	
	@GetMapping("/top/")
	public String view(Model model) {
	model.addAttribute("list",this.scheduleBookService3.getScheduleList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "top";
	}
	
	@GetMapping("/add/")
	public ModelAndView add(ScheduleBook scheduleBook, ModelAndView model) {
		model.addObject("model", scheduleBook);
		model.setViewName("user");
		return model;
	}
	
	@GetMapping("/myview/")
	public String myscheduleview(Model model) {
	model.addAttribute("list",this.scheduleBookService2.getScheduleList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "myscheduleview";
	}


@GetMapping("/my/")
public ModelAndView schedulebook2(ScheduleBook2 scheduleBook2 , ModelAndView model) {
	  model.addObject("scheduleBook2", scheduleBook2);
	  model.setViewName("myschedule");
	  return model;
	  }

@GetMapping("/all/")
public ModelAndView schedulebook3(ScheduleBook3 scheduleBook3 , ModelAndView model) {
	  model.addObject("scheduleBook3", scheduleBook3);
	  model.setViewName("allschedule");
	  return model;
	  }


@GetMapping("/mydelete/{id}")
public ModelAndView mydelete(@PathVariable(name = "id") Long id, ScheduleBook2 scheduleBook2, ModelAndView model) {
	this.scheduleBookService2.delete(id);
	model.setViewName("delete");
	return model;
}

@GetMapping("/alldelete/{id}")
public ModelAndView alldelete(@PathVariable(name = "id") Long id, ScheduleBook3 scheduleBook3, ModelAndView model) {
	this.scheduleBookService3.delete(id);
	model.setViewName("delete");
	return model;
}

@PostMapping("/add/")
public String add(@Validated @ModelAttribute @NonNull ScheduleBook scheduleBook, BindingResult valid,
		RedirectAttributes result, ModelAndView model,
		RedirectAttributes redirectAttributes) {
	try {
		this.scheduleBookService.save(scheduleBook);
		redirectAttributes.addFlashAttribute("exception", "");

	} catch (Exception e) {
		redirectAttributes.addFlashAttribute("exception", e.getMessage());
	}
	return "redirect:/";
}

@PostMapping("/my/")
public String schedulebook2(@Validated @ModelAttribute @NonNull ScheduleBook2 schedule2, RedirectAttributes result, ModelAndView model,
		RedirectAttributes redirectAttributes) {
	try {
		this.scheduleBookService2.save(schedule2);
		redirectAttributes.addFlashAttribute("exception", "");

	} catch (Exception e) {
		redirectAttributes.addFlashAttribute("exception", e.getMessage());
	}
	return "redirect:/top/";
}

@PostMapping("/all/")
public String schedulebook3(@Validated @ModelAttribute @NonNull ScheduleBook3 schedule3, RedirectAttributes result, ModelAndView model,
		RedirectAttributes redirectAttributes) {
	try {
		this.scheduleBookService3.save(schedule3);
		redirectAttributes.addFlashAttribute("exception", "");

	} catch (Exception e) {
		redirectAttributes.addFlashAttribute("exception", e.getMessage());
	}
	return "redirect:/top/";
}
}