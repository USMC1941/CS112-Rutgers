package apps.linear.simulation;

import java.util.Random;

/**
 * This class implements a source stream students for the registration queue. 
 * 
 * @author Sesh Venugopal
 *
 */
class StudentSource {
	
	/**
	 * Probability that a student arrives for registration in the next time interval. 
	 */
	float probOfArrival;
	
	/**
	 * A randomizer whose sequence of random numbers is used in concert with the
	 * probability of arrival to determine whether a student arrives for registration 
	 * in the nexttime interval.
	 */
	Random randomizer;
	
	/**
	 * Initializes a new instance with a given student arrival probability.
	 * 
	 * @param arrivalProbability Probability that a student will arrive in the next time interval.
	 * @throws IllegalArgumentException If the given arrival probability is <= 0 or > 1.
	 */
	StudentSource(float arrivalProbability) {
		if (arrivalProbability <= 0 || arrivalProbability > 1) {
			throw new IllegalArgumentException(arrivalProbability + " <= 0 or > 1");
		} else {
			probOfArrival = arrivalProbability;
		}
		randomizer = new Random();
	}
	
	/**
	 * Tells whether a student has arrived in a time interval.
	 * 
	 * @return True if student has arrived, false otherwise.
	 */
	boolean studentArrived() {
		return randomizer.nextFloat() <= probOfArrival;
	}
}
