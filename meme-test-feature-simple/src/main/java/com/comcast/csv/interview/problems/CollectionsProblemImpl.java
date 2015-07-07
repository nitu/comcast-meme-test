package com.comcast.csv.interview.problems;

import com.comcast.csv.meme.Meme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implement the specified interface.
 */
public class CollectionsProblemImpl implements CollectionsProblem {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollectionsProblemImpl.class);
	
	public void sort(Collection<Meme> memes, boolean ascending) {

		// Sorts a Collection of Memes by year
		List<Meme> listMemes = new ArrayList<Meme>();
		listMemes.addAll(memes);
		if (ascending) {
			LOGGER.info("Ascending order-by year:");
			Collections.sort(listMemes, Meme.memeAscComparator);
		} else {
			LOGGER.info("Descending order-by year:");
			Collections.sort(listMemes, Meme.memeDscComparator);
		}

		for (Meme str : listMemes) {
			LOGGER.info(""+str.getYear());
		}
	}
	
	public void addTag(Collection<Meme> memes, String tag) {
		
		for (Meme meme : memes) {
			String[] tags = meme.getTags();
			if (tags.length > 0) { // contains at least one tag
				// array to list
				List<String> updatableList = new ArrayList<String>();
				updatableList.addAll(Arrays.asList(tags));
				updatableList.add(tag);
				// list to string array
				
				meme.setTags(updatableList.toArray(new String[updatableList.size()]));
				LOGGER.info("tags length : " + meme.getTags().length);
				LOGGER.info(meme.toString());
			}
		}
		
	}
}
