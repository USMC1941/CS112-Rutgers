package apps.tree.scheduling;

import java.util.Random;

/**
 * This class implements a "source" that delivers processes into a
 * scheduling simulation system. The rate of delivery of new processes from
 * this source is controlled by an input probability.
 * 
 * @author Sesh Venugopal
 *
 */
class ProcessSource {
	
	/**
	 * Probability of arrival of a new process in the next simulation interval. 
	 */
	float probOfArrival;
	
	/**
	 * Maximum execution time of any process. 
	 */
	int maxExecTime;    
	
	/**
	 * Maximum priority of any process.
	 */
	int maxPriority;    
	
	/**
	 * A randomizer that, in conjunction with the arrival probability, will
	 * determine whether a process is delivered to the scheduling system in 
	 * the next simulation interval. 
	 */
	Random randomizer;
	
	/**
	 * Id to be assigned to next process. 
	 */
	int pid;            
	
	/**
	 * Initializes a new instance with an arrival probability for processes, maximum
	 * process execution time, and maximum priority.
	 * 
	 * @param arrivalProbability Probability that a process will arrive (be delivered) in 
	 * 							the next simulartion interval.
	 * @param maxExecTime Maximum execution time of a process.
	 * @param maxPriority Maximum priority of a process.
	 * @throws IllegalArgumentException If arrivalProbability is <= 0 or > 1
	 */
	ProcessSource(float arrivalProbability, int maxExecTime, int maxPriority) {
		if (arrivalProbability <= 0 || arrivalProbability > 1) {
			throw new IllegalArgumentException(arrivalProbability +
			" <= 0 or > 1");
		} else {
			probOfArrival = arrivalProbability;
		}
		this.maxExecTime = maxExecTime;
		this.maxPriority = maxPriority;
		randomizer = new Random();
		pid=0;
	}
	
	/**
	 * Delivers a new process if there is one that is deliverable at the time
	 * this method is called.
	 * 
	 * @return New process if one is deliverable, null if not.
	 */
	Process getProcess() {
		if (randomizer.nextFloat() <= probOfArrival) {
			pid++;
			// scale random value to desired execution time range
			int ptime = (int)(Math.random()*maxExecTime);
			if (ptime == 0) ptime++;
			// scale random value to desired priority range
			int priority = (int)(Math.random()*maxPriority);
			return new Process(pid, ptime, priority);
		}
		return null;
	}
}
