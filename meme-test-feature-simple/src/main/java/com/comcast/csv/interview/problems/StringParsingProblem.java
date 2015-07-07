package com.comcast.csv.interview.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The following methods operate on street addresses in a particular format. The format contains the following components:
 * 
 *  1. Number of miles from the center of the city
 *  2. Primary direction from the city as a single lower-case letter
 *  3. Street number
 *  4. Street name (always a single word)
 *  5. An abbreviation for either a Street or Avenue with a period
 * 
 * </h2>Example Valid Addresses</h2>
 * 25w873 Apple St.
 * 3n17 Special Ave.
 * 0e34800 Main St.
 */
public class StringParsingProblem {
	private static final Logger LOGGER = LoggerFactory.getLogger(StringParsingProblem.class);

    /**
     * Returns true if the address is valid, otherwise false.
     * 
     * @param address the address to validate
     * @return true if the address is valid
     */
    public boolean isAddressValid(String address) {
    	
    	boolean adressvalidity = false;
    	
    	String patternString = "\\d*[a-z]\\d*\\s[A-Z][a-z]*\\s[A-Z][a-z]*.";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(address);
		
        if(matcher.matches()){
        	adressvalidity = true;
        }else{
        	adressvalidity = false;
        }
        
        return adressvalidity;
    }
    
    /**
     * Get the distance in miles from the center of the city from the given address.
     * 
     * @param address the address
     * @return the distance
     */
    public int getDistanceFromCityCenter(String address) {
    	
    	int miles = 0;
    	if(isAddressValid(address)){
	    	String milesStr = address.substring(0, address.indexOf(" "));
	        String patternString = "[a-z]";
	        
	        Pattern pattern = Pattern.compile(patternString);
	        Matcher matcher = pattern.matcher(milesStr);
	        
	        if(matcher.find()) {
	        	miles = Integer.parseInt(milesStr.substring(0,matcher.start()));
	        }
    	}else{
    		LOGGER.error("Invalid Address");
    		return -1;
    	}
		return miles;
    	
    }
}