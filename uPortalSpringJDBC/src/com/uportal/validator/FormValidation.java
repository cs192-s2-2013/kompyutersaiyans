package com.uportal.validator;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  

import org.springframework.validation.Errors;  
import org.springframework.validation.ValidationUtils;  
import org.springframework.validation.Validator;  
  

import com.uportal.domain.User;  
  
public class FormValidation implements Validator {  
  
 private Pattern pattern;  
 private Matcher matcher;  
  
 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
 String ID_PATTERN = "[0-9]+";  
 String STRING_PATTERN = "[a-zA-Z]+";  
 String MOBILE_PATTERN = "[0-9]{10}";   
 String ALPHA_NUMERIC = "[A-Za-z0-9]+";
  
 @Override  
 public void validate(Object target, Errors errors) {  
  
  User user = (User) target;  

  
  ValidationUtils.rejectIfEmpty(errors, "firstName", "required.firstName",  
    "Name is required.");  
  
// input string contains characters only  
  if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {  
   pattern = Pattern.compile(STRING_PATTERN);  
   matcher = pattern.matcher(user.getFirstName());  
   if (!matcher.matches()) {  
    errors.rejectValue("firstName", "firstName.containNonChar",  
      "Enter a valid name");  
   }  
  } 
  
  ValidationUtils.rejectIfEmpty(errors, "lastName", "required.lastName",  
		  "Name is required.");  
  if (!(user.getLastName() != null && user.getLastName().isEmpty())) {  
	   pattern = Pattern.compile(STRING_PATTERN);  
	   matcher = pattern.matcher(user.getLastName());  
	   if (!matcher.matches()) {  
	    errors.rejectValue("lastName", "lastName.containNonChar",  
	      "Enter a valid name");  
	   }  
	  } 
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",  
    "required.email", "Email is required.");  
  
// email validation in spring  
  if (!(user.getEmail() != null && user.getEmail().isEmpty())) {  
   pattern = Pattern.compile(EMAIL_PATTERN);  
   matcher = pattern.matcher(user.getEmail());  
   if (!matcher.matches()) {  
    errors.rejectValue("email", "email.incorrect",  
      "Enter a correct email");  
   }  
  }  
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",  
    "required.username", "Username is required.");  
  
// phone number validation  
  if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
	   pattern = Pattern.compile(ALPHA_NUMERIC);  
	   matcher = pattern.matcher(user.getUsername());  
	   if (!matcher.matches()) {  
	    errors.rejectValue("username", "username.containNonChar",  
	      "Enter a username name");  
	   }  
	   
	   if (user.getUsername().toString().length() < 8) {  
		    errors.rejectValue("username", "username.exceed",  
		      "Username should be 8 or more characters");  
		   }  
	  } 
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",  
    "required.password", "Password is required.");  
  
  if (user.getPassword().toString().length() < 8) {  
	    errors.rejectValue("username", "username.exceed",  
	      "Password should be 8 or more characters");  
	   } 
// password matching validation  
  if (!user.getPassword().equals(user.getConfirmPassword())) {  
   errors.rejectValue("confirmPassword", "password.mismatch",  
     "Password does not match");  
  }  
 
 }

@Override
public boolean supports(Class arg0) {
	// TODO Auto-generated method stub
	return false;
}  
}  
