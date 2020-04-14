package com.swiftAcad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swiftAcad.service.ContactService;

@Controller
@RequestMapping(value="api")
public class ContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "contact/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContactByEmail(@PathVariable String email) {
			contactService.deleteContactByEmail(email);
		return new ResponseEntity<>("Contact was deleted successfully.",HttpStatus.OK);
	}
}
