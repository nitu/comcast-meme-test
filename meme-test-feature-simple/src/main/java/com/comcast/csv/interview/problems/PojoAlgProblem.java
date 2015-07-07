package com.comcast.csv.interview.problems;

import java.awt.Rectangle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Using absolute coordinates for EVERYTHING, implement the following methods to position the inner rectangle relative
 * to the outer rectangle.
 */
public class PojoAlgProblem {

	private static final Logger LOGGER = LoggerFactory.getLogger(PojoAlgProblem.class);

    /**
     * Put the inner rectangle so that it's bottom right corner aligns with the bottom right corner of the outer
     * rectangle.
     * 
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void bottomRight(Rectangle inner, Rectangle outer) {
    	double xOuter = outer.getX()+outer.getWidth();
    	double yOuter = outer.getY();
    	
    	double xInner = inner.getX()+inner.getWidth();
    	double yInner = inner.getY();
    	
    	if (xOuter == xInner && yOuter == yInner ) {
			LOGGER.info("Bottom right corner of inner aligns with the bottom right corner of the outer");
		}else{
			LOGGER.info("Bottom right corner of inner does not align with the bottom right corner of the outer");
    	}
    }

    /**
     * Put the inner rectangle so that it is centered vertically and horizontally 
     * 
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void middleCenter(Rectangle inner, Rectangle outer) {
    	double xOuter = outer.getX()+outer.getWidth()/2;
    	double yOuter = outer.getY()+outer.getHeight()/2;
    	
    	double xInner = inner.getX()+inner.getWidth()/2;
    	double yInner = inner.getY()+inner.getHeight()/2;
    	
    	if (xOuter == xInner && yOuter == yInner ) {
    		LOGGER.info("inner is centered vertically and horizontally ");
		}else{
			LOGGER.info("inner does not match centered vertically and horizontally ");
    	}
    }
}