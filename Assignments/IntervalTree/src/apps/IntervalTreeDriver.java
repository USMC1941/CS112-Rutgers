package apps;

import structures.Interval;
import structures.IntervalTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IntervalTreeDriver {

   public static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException {
      System.out.print("Enter intervals file name => ");
      String              infile    = keyboard.readLine();
      BufferedReader      br        = new BufferedReader(new FileReader(infile));
      ArrayList<Interval> intervals = readIntervals(br);
      System.out.println("Read the following intervals:");
      for (Interval interval : intervals) {
         System.out.println(interval);
      }
      IntervalTree tree = new IntervalTree(intervals);
      performQueries(tree);
   }

   public static ArrayList<Interval> readIntervals(BufferedReader br) throws IOException {
      String              line;
      ArrayList<Interval> ret = new ArrayList<>();

      while ((line = br.readLine()) != null) {
         StringTokenizer st     = new StringTokenizer(line);
         Interval        intrvl = new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
         ret.add(intrvl);
      }
      return ret;
   }

   public static void performQueries(IntervalTree tree) throws IOException {
      System.out.print("\nEnter an interval (e.g. 3 5) to intersect, quit to stop => ");
      String schedule = keyboard.readLine();
      while (!schedule.equals("quit")) {
         StringTokenizer st = new StringTokenizer(schedule);

         Interval intrvl = new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), "");

         ArrayList<Interval> intersects = tree.findIntersectingIntervals(intrvl);
         for (Interval interval : intersects) {
            System.out.println(interval);
         }

         System.out.print("\nEnter an interval (e.g. 3 5) to intersect, quit to stop => ");
         schedule = keyboard.readLine();
      }
   }
}
