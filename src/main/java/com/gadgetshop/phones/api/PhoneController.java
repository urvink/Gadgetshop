package com.gadgetshop.phones.api;

import com.gadgetshop.phones.Service.PhoneService;
import com.gadgetshop.phones.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PhoneController {
		@Autowired
		private PhoneService service;

		@GetMapping("/phones")
		public ResponseEntity<List<Phone>> getAllPhones() {
				try {
						List<Phone> phonesList = new ArrayList<>();
//						service.findAll().forEach(phonesList::add);
						phonesList = service.findAll();
						return new ResponseEntity(phonesList, HttpStatus.OK);
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

//		@PutMapping("/phones/{id}")
//		public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody()){
//
//		}
}
