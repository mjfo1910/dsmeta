package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Missoes;
import com.devsuperior.dsmeta.services.MissoesService;
import com.devsuperior.dsmeta.services.SmsMissoes;

@RestController
@RequestMapping(value  = "/missoes")
public class MissoesController {
	
	@Autowired
	private MissoesService service;
	
	@Autowired
	private SmsMissoes smsService;
	
	@GetMapping  
	public Page <Missoes> findMissoes(
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate,
            Pageable pageable) {
	return service.findMissoes(minDate, maxDate, pageable);
	
	}

	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
}
