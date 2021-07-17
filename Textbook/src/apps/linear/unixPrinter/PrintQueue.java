package apps.linear.unixPrinter;

import java.util.NoSuchElementException;
import java.io.PrintWriter;
import structures.linear.Queue;

/**
 * This class implements a printer queue, comprising of Job instances.
 * 
 * @author Sesh Venugopal
 *
 */
public class PrintQueue {
	
	/**
	 * List of jobs in this printer queue, stored in a Queue instance 
	 */
	Queue<Job> printQ;
	
	/**
	 * Initializes this printer queue to empty. 
	 */
	public PrintQueue() {
		printQ = new Queue<Job>();
	}
	
	/**
	 * Queues up a given job at this printer queue.
	 * 
	 * @param owner Name of job owner.
	 * @param jobId Id of job.
	 * @param file Name of file to be printed.
	 */
	public void lpr(String owner, int jobId, String file) {
		// create and enqueue a new job
		printQ.enqueue(new Job(owner,jobId,file));
	}
	
	/**
	 * Prints the jobs in this printer queue with a given PrintWriter.
	 * 
	 * @param pw PrintWriter used to print jobs in this queue.
	 */
	public void lpq(PrintWriter pw) {
		// step through all the entries in queue
		Job job = printQ.first();
		while (job != null) {
			pw.println(job);
			job = printQ.next();
		}
	}
	
	/**
	 * Removes the job from this printer queue that matches the given owner name
	 * and job id.
	 * 
	 * @param owner Name of job owner.
	 * @param jobId Job id.
	 * @throws NoSuchElementException If no matching job exists in this printer queue, or
	 *                                if this queue is empty.
	 */
	public void lprm(String owner, int jobId) {
		if (printQ.isEmpty()) {
			throw new NoSuchElementException();
		}
		// remove entry that matches owner and id
		printQ.remove(new IdOwnerJob(owner, jobId, null));
	}
	
	/**
	 * Removes the job at the front of his printer queue, provided its owner name
	 * matches the given owner name. 
	 * 
	 * @param owner Owner name to be matched against the job at the front of this printer queue.
	 * @throws NoSuchElementException If the job at the front does not have a matching owner name to
	 *                                given owner name, or if this queue is empty.
	 */
	public void lprm(String owner) {
		if (printQ.isEmpty()) {
			throw new NoSuchElementException();
		}
		Job front = printQ.first();
		if (owner.equals(front.owner)) {
			// dequeue if front entry has matching owner
			printQ.dequeue();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Removes all jobs in this printer queue whose owner names match with the given owner name. 
	 * 
	 * @param owner Owner name to be matched against jobs in this printer queue.
	 * @throws NoSuchElementException If no job matches the given owner name, or
	 *                                if this queue is empty.
	 */
	public void lprmAll(String owner) 
	throws NoSuchElementException {
		if (printQ.isEmpty()) {
			throw new NoSuchElementException();
		}
		// remove all entries with matching owner
		printQ.removeAll(new OwnerJob(owner, 0, null));
	}
}
