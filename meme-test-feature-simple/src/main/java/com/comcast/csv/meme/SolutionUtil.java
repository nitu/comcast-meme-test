package com.comcast.csv.meme;

import com.comcast.csv.interview.problems.LoopProblem;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionUtil {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoopProblem.class);
	
	public static String filePath = "C:\\comcast-meme-test\\meme-test-feature-simple\\src\\main\\resources\\json\\meme.json";
	
	public static JSONArray createData() {
		// Create Array of JSON objects
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(getJson("Nitu", 1981, new String[] { "Java", "11",
				"GU" }));
		jsonArray.add(getJson("Neeraj", 1980, new String[] {
				"Salesforce", "10", "GU" }));
		jsonArray.add(getJson("Priyanka", 1977, new String[] {
				"Routing Protocol", "15", "NU" }));
		jsonArray.add(getJson("Anuj", 1989, new String[] {
				"Engine Design", "4", "IITKGP" }));
		
		return jsonArray;
	}

	/**
	 * 
	 * @param filePath
	 * @param jsonObj
	 */
	public static int writeToFileSystem(String filePath, JSONArray jsonArray) {
		// Write to fileSystem
		FileWriter file = null;
		try {
			file = new FileWriter(filePath);
			file.write(jsonArray.toJSONString());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return -1;
		} finally {
			try {
				file.flush();
				file.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
				return -1;
			}
		}
		return 1;
	}

	/**
	 * 
	 * @param name
	 * @param year
	 * @param tags
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static JSONObject getJson(String name, int year,
			String[] tags) {
		// Create JSONObject
		JSONObject json = new JSONObject();
		JSONArray jsontags = new JSONArray();
		for (String tag : tags) {
			jsontags.add(tag);
		}
		json.put("name", name);
		json.put("year", String.valueOf(year));
		json.put("tags", jsontags);

		return json;
	}

}
