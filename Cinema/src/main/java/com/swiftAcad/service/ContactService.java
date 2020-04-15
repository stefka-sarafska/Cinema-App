package com.swiftAcad.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Contact;
import com.swiftAcad.exceptions.ContactException;
import com.swiftAcad.repository.ContactRepository;

@Component
public class ContactService {
	private static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String PHONE_REGEX = "(^((\\+\\d{1,3})|(0))(\\s)*((\\d{2,4})(\\s)*){3})";

	@Autowired
	private ContactRepository contactRepo;

	//update only phone and address
	public Contact updateContactByEmail(Contact newContact) throws ContactException {
		Contact contact = contactRepo.findByEmail(newContact.getEmail());
		if (contact != null) {
			return contactRepo.save(newContact);
		}else {
			throw new ContactException("Can not update contact with email: "+newContact.getEmail()+" ,because does not exist!");
		}
		
	}

	public void deleteContactByEmail(String email){
		contactRepo.deleteByEmail(email);
	}
	
	
	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(PHONE_REGEX);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.find();
	}

}
