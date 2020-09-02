# Programming Assignment Friendship Graph Algorithms - Test Cases

## `shortestChain`: 35 pts

1. 3 pts: file [sptest1.txt](sptest1.txt)

   Input: `aparna, kaitlin`

   Result: Empty

2. 4 pts: file [subtest3.txt](subtest3.txt)

   Input: `kaitlin, nick`

   Result: `[kaitlin,nick]`

3. 7 pts: file [assnsample.txt](assnsample.txt)

   Input: `nick, aparna`

   Result: `[nick,ricardo,aparna]`

4. 7 pts: file [sptest4.txt](sptest4.txt)

   Input: `p1, p50`

   Result: `[p1,p49,p50]` OR `[p1,p51,p50]`

5. 7 pts: file [subtest5.txt](subtest5.txt)

   Input: `p1, p10`

   Result: `[p1,p2,p3,p4,p5,p6,p7,p8,p9,p10]`

6. 7 pts: file [subtest5.txt](subtest5.txt)

   Input: `p301, p198`

   Result: `[p301,p100,p99,p98,p198]`

## `cliques`: 25 pts

Note: For the non-empty results, order of names within a list does not matter. So any permutation of the results given here would be fine. (This includes a different order of lists within the top level list, as well.)

1. 2 pt: file [subtest1_2.txt](subtest1_2.txt)

   Input: `cornell`

   Result: Empty

2. 3 pt: file [subtest1_2.txt](subtest1_2.txt)

   Input: `rutgers`

   Result: `[[kaitlin]]`

3. 5 pts: file [subtest3.txt](subtest3.txt)

   Input: `rutgers`

   Result: `[[sara],[kaitlin]]`

4. 5 pts: file [clqtest4.txt](clqtest4.txt)

   Input: `rutgers`

   Result: `[[p1,p2,p3,p4]]`

5. 5 pt: file [assnsample.txt](assnsample.txt)

   Input: `rutgers`

   Result: `[[sam,jane,bob,kaitlin],[sergei,aparna]]`

6. 5 pt: file [subtest5.txt](subtest5.txt)

   Input: `rutgers`

   Result: `[[p3,p104,p4,p204],[p98,p199,p99,p299]]`

## `connectors`: 40 pts

Note: For the non-empty results, order of names within a list does not matter. So any permutation of the results for #5 and #6 given here would be fine.

1. 4 pts: file [subtest1_2.txt](subtest1_2.txt)

   Result: Empty

2. 4 pts: file [clqtest4.txt](clqtest4.txt)

   Result: Empty

3. 8 pts: file [subtest3.txt](subtest3.txt)

   Result: `[nick]`

4. 8 pts: file [subtest4.txt](subtest4.txt)

   Result: `[p1]`

5. 8 pts: file [assnsample.txt](assnsample.txt)

   Result: `[jane, aparna, nick, tom, michele]`

6. 8 pts: file [conntest6.txt](conntest6.txt)

   Result: `[p2,p3,p4]`
