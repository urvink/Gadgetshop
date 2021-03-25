package com.gadgetshop.phones.api;

import com.gadgetshop.phones.Service.PhoneService;
import com.gadgetshop.phones.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PhoneController {
		@Autowired
		private PhoneService service;

		/*
		@GetMapping("/test")
		public String showTestPage(Model model){
				List<String> testers = new ArrayList<>();
				testers.add("Mourad");
				testers.add("Issay");
				testers.add("Melissa");
				model.addAttribute("testers", testers);
				return "test";
		}*/

		@GetMapping("/phones")
		public ResponseEntity<List<Phone>> getAllPhones(Model model, HttpServletRequest request) {
				try {
						List<Phone> phonesList = service.findAll();
						if (phonesList.isEmpty()) {
//						service.findAll().forEach(phonesList::add);
								return new ResponseEntity(phonesList, HttpStatus.OK);
						} else {
								return new ResponseEntity("Nothing found", HttpStatus.NO_CONTENT);
						}

				} catch (Exception e) {
						return new ResponseEntity("OOOPS", HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@GetMapping("/phones/{id}")
		public ResponseEntity<Phone> getPhoneDetails(@PathVariable Long id) {
				try {
						Optional<Phone> phoneDetails = service.findById(id);
						if (phoneDetails.isPresent()) {
								return new ResponseEntity(phoneDetails, HttpStatus.OK);
						} else {
								return new ResponseEntity("No phones were found", HttpStatus.NO_CONTENT);
						}
				} catch (Exception e) {
						return new ResponseEntity("Server is unavailable", HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@PutMapping(value = "/phones/{id}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone data, HttpServletRequest request) {
				String putData = data.get_img();
				return new ResponseEntity(putData, HttpStatus.OK);
		}
}