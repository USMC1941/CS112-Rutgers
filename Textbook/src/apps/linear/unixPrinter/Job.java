package apps.linear.unixPrinter;

/**
 * This class encapsulates a print job comprising job id, name of job owner,
 * and name of file to be printed. It is only visible within its package.
 * 
 * @author Sesh Venugopal
 *
 */
class Job {
	
	/**
	 * Name of job owner.
	 */
	String owner;
	
	/**
	 * Job id, unique with respect to all jobs in the queue at any time
	 */
	int id;
	
	/**
	 * Name of file to be printed.
	 */
	String file;
	
	/**
	 * Initializes a job instance with job id, name of owner, name of file to be printed.
	 * 
	 * @param ownerName Name of job owner.
	 * @param jobId Id of job.
	 * @param fileName Name of file to be printed.
	 */
	Job(String ownerName, int jobId, String fileName) {
		owner = ownerName;
		id = jobId;
		file = fileName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new String(owner + " " + id + " " + file);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Job)) {
			// equality based on job id only
			Job another = (Job)other;
			return (id == another.id);
		}
		return false;
	}
}

/**
 * This class encapsulates a print job with a specialization of the equality condition,
 * in that two OwnerJob instances are equal if their owner names are the same.
 * 
 * @author Sesh Venugopal
 *
 */
class OwnerJob extends Job {
	
	/**
	 * Initializes an owner job instance with job id, name of owner, name of file to be printed.
	 * 
	 * @param owner Name of job owner.
	 * @param jobId Id of job.
	 * @param fileName Name of file to be printed.
	 */
	OwnerJob(String owner, int jobId, String fileName) {
		super(owner, jobId, fileName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Job)) {
			// equality based on job owner only
			Job another = (Job)other;
			return (owner.equals(another.owner));
		}
		return false;
	}
}

/**
 * This class encapsulates a print job with a specialization of the equality condition,
 * in that two IdOwnerJob instances are equal if their ids and owner names are the same.
 * 
 * @author Sesh Venugopal
 *
 */
class IdOwnerJob extends Job {
	
	/**
	 * Initializes an IdOwner job instance with job id, name of owner, name of file to be printed.
	 * 
	 * @param owner Name of job owner.
	 * @param jobId Id of job.
	 * @param fileName Name of file to be printed.
	 */
	IdOwnerJob(String owner, int jobId, String fileName) {
		super(owner, jobId, fileName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((other != null) && (other instanceof Job)) {
			// equality based on both owner and id
			Job another = (Job)other;
			return (owner.equals(another.owner) && id == another.id);
		}
		return false;
	}
}

