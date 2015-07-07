package com.comcast.csv.interview.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;

/**
 * Read a list of {@link Meme}s from a JSON source file that might be on the classpath or file system.
 */
public class FileJsonResourceProblem {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollectionsProblemImpl.class);
	
    /**
     * Read a list of memes from a JSON file stored on the filesystem
     * 
     * @param file the file to read
     * @return the list of memes read
     */
    public List<Meme> readFromFile(File file) throws YoureDoingItWrongException {
    	
    	List<Meme> listMemes = null;
    	
    	try {
    		JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray)parser.parse(new FileReader(file));
			listMemes = getMemeList(jsonArray);
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage());
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}
		return listMemes;
    }

	/**
     * Read a list of memes from a JSON file stored on the classpath
     * 
     * @param path the path to the resource
     * @return the list of memes read
     */
    public List<Meme> readFromClasspath(String path) throws YoureDoingItWrongException {
    	
    	InputStream in = this.getClass().getClassLoader().getSystemResourceAsStream(path);
    	List<Meme> listMemes = null;
    	
    	try {
    		JSONParser parser = new JSONParser();
    		if(in==null){
    			return listMemes;
    		}
			JSONArray jsonArray = (JSONArray)parser.parse(new InputStreamReader(in));
			listMemes = getMemeList(jsonArray);
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}
		return listMemes;
    }
    
    /**
     * 
     * @param jsonArray
     * @return
     */
	private List<Meme> getMemeList(JSONArray jsonArray) {
	    
		List<Meme> listMemes = new ArrayList<Meme>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArray.get(i);
			
			String name = jsonObj.get("name").toString();
		int year = Integer.parseInt(jsonObj.get("year").toString());
		JSONArray tags = (JSONArray)jsonObj.get("tags");
			
			String[] tagsStringArr =  new String[tags.size()];
			for (int j = 0; j < tags.size(); j++) {
				tagsStringArr[j] = (String) tags.get(j);
			}
			listMemes.add(createMemeObj(name, year, tagsStringArr));
		}
		return listMemes;
		
	}
    /**
	 * 
	 * @param name
	 * @param year
	 * @param tags
	 * @return memeObj
	 */
	private static Meme createMemeObj(String name, int year, String[] tags){
		Meme memeObj = new Meme();
		memeObj.setName(name);
		memeObj.setYear(year);
		memeObj.setTags(tags);
		
		return memeObj;
	}

}