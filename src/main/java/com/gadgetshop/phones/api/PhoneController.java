package com.gadgetshop.phones.api;

import com.gadgetshop.phones.Service.PhoneService;
import com.gadgetshop.phones.model.Phone;
import com.gadgetshop.phones.model.mutatePhoneStock;
import com.gadgetshop.phones.utils.StatusMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phones")
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
		@GetMapping
		public ResponseEntity<List<Phone>> getAllPhones(HttpServletRequest request, Model model) {
				try {
						List<Phone> phonesList = service.findAll();

//						service.findAll().forEach(phonesList::add);
						model.addAttribute("phones", phonesList);
						return new ResponseEntity(model, HttpStatus.OK);
				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		//Thymeleaf FRIENDLY
//		@GetMapping
//		public String getAllPhones(Model model){
//				try{
//
//
//				List<Phone> allPhones = service.findAll();
//
//				if (allPhones!= null){
//						model.addAttribute(allPhones);
//
//				}else{
//						return StatusMessages.error404;
//				}
//				}catch (Exception e){
//						return StatusMessages.error500;
//				}
//				return "index";
//		}

		@GetMapping
		public ResponseEntity<Phone> getPhoneDetails(@PathVariable Long id) {
				try {
						Optional<Phone> phoneDetails = service.findById(id);
						if (phoneDetails.isPresent()) {
								return new ResponseEntity(phoneDetails, HttpStatus.OK);
						} else {
								return new ResponseEntity("No phones were found", HttpStatus.NO_CONTENT);
						}
				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
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
		public ResponseEntity<Phone> createPhone(@RequestHeader(value = "Content-Type") String contentType, @RequestBody Phone newPhoneData) {
				try {
						if ((contentType != null) && (contentType.equals("application/json"))) {
								Phone savedPhone = service.createNewPhone(newPhoneData);
								return new ResponseEntity(savedPhone, HttpStatus.CREATED);
						} else {
								return new ResponseEntity("Only application/json accepted", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
						}
				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		/**
		 * UPDATE PHONE
		 * |-------------|
		 * TODO: Make it modular!!
		 *
		 * @param id
		 * @param newPhoneData
		 * @param request
		 * @return
		 */
		@PutMapping(path = "/phones/{id}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone newPhoneData, HttpServletRequest request) {
				try {
						String headers = request.getContentType();

						Optional<Phone> existedPhone = service.findById(id);

						if (existedPhone != null) {
								Phone updatedPhone = service.updatePhoneDetails(newPhoneData);
								return new ResponseEntity(updatedPhone, HttpStatus.OK);
						} else {
								return new ResponseEntity("Duuude, where is my phone", HttpStatus.NO_CONTENT);
						}
				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@PutMapping(path = "/phones/{id}/mutate", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Phone> mutateStock(@PathVariable Long id, @RequestBody mutatePhoneStock mutation, HttpServletRequest request) {
				try {
						Optional<Phone> phoneData = service.findById(id);
						Integer currentStock = phoneData.get().get_stockAmount();
						switch (mutation.getType()) {
								case "replenish":
										currentStock = currentStock + mutation.getStockAmount();
										break;
								default:
										currentStock = currentStock - mutation.getStockAmount();
						}
						phoneData.get().set_stockAmount(currentStock);
						Phone newUpdatedPhoneData = service.updatePhoneDetails(phoneData.get());
						System.out.println(phoneData.get().get_stockAmount());
						return new ResponseEntity(newUpdatedPhoneData, HttpStatus.OK);
				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
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
		public ResponseEntity deletePhone(@PathVariable Long id, HttpServletRequest request) {
				Optional<Phone> existPhone = service.findById(id);
				try {
						if (existPhone != null) {
								service.deleteById(id);
						} else {
								return new ResponseEntity("Uhhh....dude! Where's my phone", HttpStatus.NO_CONTENT);
						}
						return new ResponseEntity("Phone is SUCCESSfully DELETED!", HttpStatus.OK);
				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@DeleteMapping(path = "/phones/")
		public ResponseEntity batchDelete(@RequestBody List<Long> ids, HttpServletRequest request) {
				try {
						return new ResponseEntity(ids, HttpStatus.OK);

				} catch (Exception e) {
						return new ResponseEntity(StatusMessages.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}