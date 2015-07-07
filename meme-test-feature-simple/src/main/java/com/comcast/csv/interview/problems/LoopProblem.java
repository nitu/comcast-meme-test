package com.comcast.csv.interview.problems;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.comcast.csv.meme.Meme;

/**
 * Using all forms of loops and recursions to iterate over a {@link List} of {@link Meme}s and log it's name and year.
 * Format of the log message isn't important.
 */
public class LoopProblem {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoopProblem.class);
	
	/**
	 * 
	 * @param listMemeObjects
	 */
	public void loopMemeForeach(List<Meme> listMemeObjects) {
		
		LOGGER.info("Foreach");
		for (Meme meme : listMemeObjects) {
			LOGGER.info("Name : "+meme.getName());
			LOGGER.info("Year : "+String.valueOf(meme.getYear()));
		}
	}

	/**
	 * 
	 * @param listMemeObjects
	 */
	public void loopMemeIterate(List<Meme> listMemeObjects) {
		
		LOGGER.info("Iterate");
		Iterator<Meme> it = (Iterator<Meme>)listMemeObjects.iterator();
		while (it.hasNext()) {
			Meme meme = (Meme) it.next();
			LOGGER.info("Name : "+meme.getName());
			LOGGER.info("Year : "+String.valueOf(meme.getYear()));
		}
		
	}

	/**
	 * 
	 * @param listMemeObjects
	 */
	public void loopMemeArray(List<Meme> listMemeObjects) {
		
		LOGGER.info("Array");
		for (int i = 0; i < listMemeObjects.size(); i++) {
			Meme meme = (Meme) listMemeObjects.get(i);
			LOGGER.info("Name : "+meme.getName());
			LOGGER.info("Year : "+String.valueOf(meme.getYear()));
		}
		
	}

	/**
	 * 
	 * @param listMemeObjects
	 */
	public void loopMemeWhile(List<Meme> listMemeObjects) {
		
		LOGGER.info("While");
		int i = 0;
		while (i < listMemeObjects.size()) {
			Meme meme = (Meme)listMemeObjects.get(i);
			LOGGER.info("Name : "+meme.getName());
			LOGGER.info("Year : "+String.valueOf(meme.getYear()));	
			i++;
		}
		

	}
	
	/**
	 * 
	 * @param listMemeObjects
	 */
	public void loopMemeRecursion(List<Meme> listMemeObjects) {
		LOGGER.info("Recursion");
		if( listMemeObjects.isEmpty() ) return;
	    Meme meme = listMemeObjects.get(0) ;
	    LOGGER.info("Name : "+meme.getName());
		LOGGER.info("Year : "+String.valueOf(meme.getYear()));
		loopMemeRecursion(listMemeObjects.subList(1,listMemeObjects.size()));

		
	}
}
