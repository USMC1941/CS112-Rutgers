package apps.tree.scheduling;

import structures.tree.Heap;
import java.io.PrintWriter;

/**
 * This class acts as the coordinator of all scheduling activities in the
 * simulation, working with the Process, ProcessSource, and Processor classes.
 * 
 * @author Sesh Venugopal
 *
 */
public class Scheduler {
	
	/**
	 * Source that delivers new processes to the simulation system.
	 */
	ProcessSource source; 
	
	/**
	 * Processor that executes processes. 
	 */
	Processor cpu; 
	
	/**
	 * Processor heap that stores processes that are in the scheduling system in
	 * a priority queue.
	 */
	Heap<Process> procHeap; 
	
	/**
	 * Total number ofprocessors that have completed execution so far.
	 */
	int thruPut;
	
	/**
	 * Number of processors that have completed execution in the latest simulation interval of
	 * interest.
	 */
	int intervalThruPut;  
	
	/**
	 * Total number of processes that have arrived in the simulation system so far.
	 */
	int numProcs;
	
	/**
	 * Number of process that have arrived in the system in the latest simulation interval of 
	 * interest.
	 */
	int intervalNumProcs;
	
	/**
	 * Clock that keeps total simulation time.
	 */
	int clock;
	
	/**
	 * Clock that keeps time for latest simulation interval of interest. 
	 */
	int intervalClock;
	
	/**
	 * Initializes a new instance by setting the process priority queue to empty.
	 */
	public Scheduler() {
		procHeap = new Heap<Process>();
	}
	
	/**
	 * Initializes various scheduling parameters with given values.
	 * 
	 * @param probOfArrival Probability of arrival of a new process in a simulation unit of time.
	 * @param maxExecTime Maximum execution time of a process.
	 * @param maxPriority Maximum priority of a process.
	 * @param timeSlice Time slice to be asssigned to each process at the processor.
	 */
	public void init(float probOfArrival, int maxExecTime,
			int maxPriority, int timeSlice)	{
		// create system objects and initialize
		source = new ProcessSource(probOfArrival, maxExecTime, maxPriority);
		cpu = new Processor(timeSlice);
		procHeap.clear();
		clock = 0;
		numProcs = 0;
		thruPut = 0;
	}
	
	/**
	 * Runs the simulation for a given number of unit time intervals.
	 * 
	 * @param howLong Number of unit time intervals for which to run the simulation.
	 * @throws BusyInterruptionException If the processor is interrupted when it is busy
	 * 									executing a process.
	 */
	public void run(int howLong) 
	throws BusyInterruptionException {
		intervalClock = 0;
		intervalNumProcs = 0;
		intervalThruPut = 0;
		// run for specified number of cycles
		while (intervalClock < howLong) {
			
			// has a new process arrived?
			Process process = source.getProcess();
			if (process != null) {
				process.arrivalTime = clock;
				procHeap.add(process);
				intervalNumProcs++;
				numProcs++;
			}
			
			// if cpu is idle, put last executed processor back on
			// heap, and schedule the process with max priority
			if (cpu.isIdle()) {
				process = cpu.getProcess();
				if (process != null) { // remaining execution time
					process.execTime -= cpu.timeSlice;
					if (process.execTime > 0) { // decrease priority of process
						process.priority--;
						if (process.priority < 0) process.priority = 0;
						process.arrivalTime = clock;
						// reenter with lower priority
						procHeap.add(process);
					} else {
						thruPut++;
						intervalThruPut++;
					}
				}
				
				if (!procHeap.isEmpty()) { // start execution another process
					Process temp = procHeap.deleteMax();
					cpu.startUp(temp);
				}
			}
			
			// step up the time
			clock++;
			intervalClock++;
			cpu.stepTime();
		}
	}
	
	/**
	 * Prints the status of the simulation system.
	 * 
	 * @param pw PrintWriter used to print status.
	 */
	public void printStatus(PrintWriter pw) {
		pw.println("                    Interval Cumulative");
		pw.println("Processes Arrived       " + 
				intervalNumProcs +
				"        " + numProcs);
		pw.println("Throughput              " + 
				intervalThruPut +
				"        " + thruPut);
		pw.flush();
	}
	
	/**
	 * Prints the contents of the process priority queue/heap.
	 * 
	 * @param pw PrintWriter used to write heap. 
	 */
	public void printHeap(PrintWriter pw) {
		pw.print("Heap: ");
		Process proc = procHeap.first();
		while (proc != null) {
			pw.print(proc + "  ");
			proc = procHeap.next();
		}
		pw.println();
		pw.flush();
	}
	
	/**
	 * Prints the contents of the CPU
	 * 
	 * @param pw PrintWriter used to print cpu contents.
	 */
	public void printProcessor(PrintWriter pw) {
		pw.println("Processor:  " + cpu);
	}
}
