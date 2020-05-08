package friends;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

class Friend {
   int    fnum;
   Friend next;

   Friend(int fnum, Friend next) {
      this.fnum = fnum;
      this.next = next;
   }
}

class Person {
   String  name;
   boolean student;
   String  school;
   Friend  first;
}


class Edge {
   int v1, v2;

   Edge(int v1, int v2) {
      this.v1 = v1;
      this.v2 = v2;
   }
}

public class Graph {

   // all the members in the graph
   Person[] members;

   // hash map to store the (name,num) association
   HashMap<String, Integer> map;

   // initialize graph from file
   public Graph(Scanner sc) {
      // first line is number of people
      int n = Integer.parseInt(sc.nextLine());
      members = new Person[n];
      map = new HashMap<>(n * 2);
      // next n lines are people's info
      for (int i = 0; i < n; i++) {
         String          info   = sc.nextLine();
         StringTokenizer st     = new StringTokenizer(info, "|");
         Person          person = new Person();
         person.name = st.nextToken();
         String yn = st.nextToken(); // student or not
         person.student = false;
         person.school = null;
         if (yn.toLowerCase().charAt(0) == 'y') {
            person.student = true;
            person.school = st.nextToken();
         }
         person.first = null;
         // add to members
         members[i] = person;
         // add to hash map
         map.put(person.name, i);
      }
      // rest are friendships
      while (sc.hasNextLine()) {
         String          line = sc.nextLine();
         StringTokenizer st   = new StringTokenizer(line, "|");
         String          p1   = st.nextToken();
         String          p2   = st.nextToken();
         int             i    = map.get(p1);
         int             j    = map.get(p2);
         members[i].first = new Friend(j, members[i].first);
         members[j].first = new Friend(i, members[j].first);
      }
   }
}
