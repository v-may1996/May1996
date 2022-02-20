package com.nals.restapi.demo.workcontroller;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nals.restapi.demo.workexception.ResourceNotFoundWorkException;
import com.nals.restapi.demo.workmodel.Work;
import com.nals.restapi.demo.workrepository.WorkRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RestController
@RequestMapping("/api/")
public class WorkController {

	private WorkRepository workRepository;

	public WorkRepository getWork() {
		return workRepository;
	}

	@Autowired
	public void setWork(WorkRepository workRepository) {
		this.workRepository = workRepository;
	}

	/**
	 * get list work
	 * @return
	 */
	@GetMapping("/works")
	public List<Work> getAllWorks() {
		return workRepository.findAll();
	}
	
	/**
	 * add work
	 * @param work
	 * @return
	 */
	@PostMapping("/works")
	public Work createWork(@RequestBody Work work) {
		return workRepository.save(work);
	}
	
	/**
	 * find work by id
	 * @param id
	 * @return
	 */
	@GetMapping("/works/{id}")
	public ResponseEntity<Work> getWorkById(@PathVariable Long id) {
		String message = "Work not exits with id: ";
		Work work = workRepository.findById(id).orElseThrow(() -> new ResourceNotFoundWorkException(message + id));
		return ResponseEntity.ok(work);
	}
	
	/**
	 * update (edit)
	 * @param id
	 * @param workDatails
	 * @return
	 */
	@PutMapping("/works/{id}")
	public ResponseEntity<Work> updateWork(@PathVariable Long id, @RequestBody Work workDatails) {
		String message = "Work not exits with id: ";
		Work work = workRepository.findById(id).orElseThrow(() -> new ResourceNotFoundWorkException(message + id));

		work.setNameWork(workDatails.getNameWork());
		work.setStartDate(workDatails.getStartDate());
		work.setEndDate(workDatails.getEndDate());
		work.setStatusId(workDatails.getStatusId());

		Work updateWork = workRepository.save(work);
		return ResponseEntity.ok(updateWork);
	}
	
	/**
	 * delete
	 * @param id
	 * @return
	 */
	@DeleteMapping("/works/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteWork(@PathVariable Long id) {
		String message = "Work not exits with id: ";
		Work work = workRepository.findById(id).orElseThrow(() -> new ResourceNotFoundWorkException(message + id));
		workRepository.delete(work);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
