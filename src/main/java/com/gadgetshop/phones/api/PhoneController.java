package com.gadgetshop.phones.api;

import com.gadgetshop.phones.Service.PhoneService;
import com.gadgetshop.phones.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

		/**
		 * GET SECTION
		 * ------------
		 *
		 * @param request
		 * @return ResponseEntity<List < Phone>>
		 */
		@GetMapping(path = "/phones")
		public ResponseEntity<List<Phone>> getAllPhones(HttpServletRequest request) {
				try {
						List<Phone> phonesList = service.findAll();

//						service.findAll().forEach(phonesList::add);
						return new ResponseEntity(phonesList, HttpStatus.OK);
				} catch (Exception e) {
						return new ResponseEntity("OOOPS", HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@GetMapping(path = "/phones/{id}")
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

		/**
		 * -----------
		 * PUT SECTION
		 * -----------
		 * CREATE NEW PHONE!!
		 * |-----------------|
		 *
		 * @param newPhoneData
		 * @return ResponseEntity
		 * <p>
		 * TODO: Make it modular!!
		 */
		@PutMapping(path = "/phones", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Phone> createPhone(@RequestBody Phone newPhoneData) {
				try {
						Phone savedPhone = service.createNewPhone(newPhoneData);
						return new ResponseEntity(savedPhone, HttpStatus.CREATED);
				} catch (Exception e) {
						return new ResponseEntity("Unable to create resource", HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		/**
		 * UPDATE PHONE
		 * |-------------|
		 * TODO: Make it modular!!
		 *
		 * @param id
		 * @param data
		 * @param request
		 * @return
		 */
		@PutMapping(path = "/phones/{id}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone data, HttpServletRequest request) {

				try {
						Optional<Phone> existedPhone = service.findById(id);
						if (existedPhone != null) {

						} else {
								return new ResponseEntity<>("Duuude, where is my phone", HttpStatus.NO_CONTENT);
						}

						String putData = data.get_img();
						return new ResponseEntity(putData, HttpStatus.OK);
				} catch (Exception e) {
						return new ResponseEntity("OOOPS....something went HORRIBLY wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		/**
		 * DELETE SECTION
		 * ---------------
		 *
		 * @param id - Long
		 * @return ResponseEntity
		 */
		@DeleteMapping(value = "/phones/{id}")
		public ResponseEntity deletePhone(@PathVariable Long id) {
				Optional<Phone> existPhone = service.findById(id);
				try {
						if (existPhone != null) {
								service.deleteById(id);
						} else {
								return new ResponseEntity("Uhhh....dude! Where's my phone", HttpStatus.NO_CONTENT);
						}
						return new ResponseEntity("Phone is SUCCESSfully DELETED!", HttpStatus.OK);
				} catch (Exception e) {
						return new ResponseEntity("OOPS.....Something went SERIOUSLY wrong", HttpStatus.INTERNAL_SERVER_ERROR);
				}


		}
}