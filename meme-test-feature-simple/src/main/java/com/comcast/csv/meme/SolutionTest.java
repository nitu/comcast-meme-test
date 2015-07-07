/**
 * 
 */
package com.comcast.csv.meme;

import com.comcast.csv.interview.problems.CollectionsProblem;
import com.comcast.csv.interview.problems.CollectionsProblemImpl;
import com.comcast.csv.interview.problems.FileJsonResourceProblem;
import com.comcast.csv.interview.problems.LoopProblem;
import com.comcast.csv.interview.problems.PojoAlgProblem;
import com.comcast.csv.interview.problems.StringParsingProblem;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nsaksena
 * Main executing class
 */
public class SolutionTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoopProblem.class);

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) { 

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

		String flieSystemPath = "C://Users//nsaksena//Downloads//meme-test-feature-simple[1] (1)//meme-test-feature-simple//src//main//resources//json//meme.json";
		writeToFileSystem(flieSystemPath, jsonArray);

		// Read JSONObjects from file system
		FileJsonResourceProblem fileJsonResourceProblem = new FileJsonResourceProblem();
		List<Meme> listMemeObjects = null;

		try {
			listMemeObjects = fileJsonResourceProblem.readFromFile(new File(
					flieSystemPath));
			LOGGER.info("FileJsonResourceProblem- FileSystem Length: "
					+ listMemeObjects.size());

			// Read JSONObjects from class path
			// run with arguments: -classpath resources:json
			List<Meme> listMemeObjectsFromClassPath = fileJsonResourceProblem
					.readFromClasspath("json/meme.json");
			LOGGER.info("FileJsonResourceProblem -Classpath Length: "
					+ listMemeObjects.size());

		} catch (YoureDoingItWrongException e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("CollectionsProblem ### 1");
		CollectionsProblem collectionsProblem = new CollectionsProblemImpl();
		collectionsProblem.sort(listMemeObjects, true);
		collectionsProblem.sort(listMemeObjects, false);
		collectionsProblem.addTag(listMemeObjects, "tag Jul 07");

		LOGGER.info("LoopProblem Solved ### 3");
		LoopProblem loopProblem = new LoopProblem();
		loopProblem.loopMemeForeach(listMemeObjects);
		loopProblem.loopMemeIterate(listMemeObjects);
		loopProblem.loopMemeArray(listMemeObjects);
		loopProblem.loopMemeWhile(listMemeObjects);
		loopProblem.loopMemeRecursion(listMemeObjects);

		LOGGER.info("PojoAlgo Problem ### 4");

		// Create Data
		Rectangle outer = new Rectangle(0, 0, 4, 4);
		Rectangle inner = new Rectangle(0, 0, 2, 1);
		Rectangle outer1 = new Rectangle(0, 0, 4, 4);
		Rectangle inner1 = new Rectangle(2, 0, 2, 2);

		// Bottom right problem
		PojoAlgProblem pojoPojoAlgProblem = new PojoAlgProblem();
		pojoPojoAlgProblem.bottomRight(outer, inner);
		pojoPojoAlgProblem.bottomRight(outer1, inner1);

		// Middle center problem
		Rectangle outerCenter = new Rectangle(0, 0, 2, 2);
		Rectangle innerCenter = new Rectangle();
		innerCenter.setRect(0.5, 0.5, 1, 1);
		pojoPojoAlgProblem.middleCenter(innerCenter, outerCenter);

		LOGGER.info("String Parsing problem ### 5");
		StringParsingProblem stringParsingProblemObj = new StringParsingProblem();
		String msg = "The distance(miles) from city center: ";
		LOGGER.info(msg
				+ stringParsingProblemObj
						.getDistanceFromCityCenter("12n755 Capitol St."));
		LOGGER.info(msg
				+ (stringParsingProblemObj
						.getDistanceFromCityCenter("85e@325 Tasman Dr.") > 0 ? msg
						+ stringParsingProblemObj
								.getDistanceFromCityCenter("85e@325 Tasman Dr.")
						: "Invalid Address"));

	}

	/**
	 * 
	 * @param filePath
	 * @param jsonObj
	 */
	private static void writeToFileSystem(String filePath, JSONArray jsonArray) {
		// Write to fileSystem
		FileWriter file = null;
		try {
			file = new FileWriter(filePath);
			file.write(jsonArray.toJSONString());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} finally {
			try {
				file.flush();
				file.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
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