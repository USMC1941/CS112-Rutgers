# Programming Assignment - Radixsort

In this assignment you will implement a sorting algorithm called radix sort.

## Rules

-   You will work on this assignment individually. Read the [DCS Academic Integrity Policy for Programming Assignments](http://www.cs.rutgers.edu/academics/undergraduate/academic-integrity-policy/programming-assignments) - you are responsible for abiding by the policy. In particular, note that "**All Violations of the Academic Integrity Policy will be reported by the instructor to the appropriate Dean**".

-   **IMPORTANT - READ THE FOLLOWING CAREFULLY!!!**

    Assignments emailed to the instructor or TAs will be ignored--they will NOT be accepted for grading.

    We will only grade submissions in Sakai.
    If your program does not compile, you will not get any credit.

    Most compilation errors occur for two reasons:

    1. You are programming outside Eclipse, and you delete the "package" statement at the top of the file. If you do this, you are changing the program structure, and it will not compile when we test it.
    2. You make some last minute changes, and submit without compiling.

    **To avoid these issues, (a) START EARLY, and give yourself plenty of time to work through the assignment, and (b) Submit a version well before the deadline so there is at least something in Autolab to grade.**

## Background

Read Section 13.4 of the textbook for a detailed description of the radix sort algorithm, and understand it well before you start. The term "radix" is used to mean the base of the number system of the input data. Decimal numbers are radix 10, binary numbers are radix 2, hexadecimal numbers are radix 16, octal numbers are radix 8.

Hexadecimal numbers have digits in the range 0-15, represented by 0-9, and A-F (for 10-15). Since the number is a mix of numbers and letters, they need to be stored as strings. Since radix sort can work on any radix, the input data to the algorithm is a set of strings that represent numbers in the given radix.

## Implementation and Grading

You will see a project called `Radixsort` with classes `Radixsort` and `Sorter` in package `apps`, and class `Node` in package `structures`.

You need to fill in the implementation of the `Radixsort` class where indicated in the `Radixsort.java` source file. This includes the following:

|           Method            | Grading Points |
| :-------------------------: | :------------: |
| `createMasterListFromInput` |       10       |
|          `scatter`          |       25       |
|          `gather`           |       15       |

### Notes

-   Digit values must be obtained by extracting the character at the digit position, and then converting it to its numeric value using the [`Character.digit(char ch, int radix)`](<https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#digit(char,int)>) method in the `java.lang` package. See the documentation for this method. So, for instance, `Character.digit('B', 16)` would return the numeric value `11`.
-   After the master list is created in the `createMasterListFromInput` method, your code should NOT create any new nodes. The `scatter` and `gather` methods must recirculate the same set of initial nodes.
-   Observe the following rules while working on `Radixsort.java`:
    -   You may NOT add any `import` statements to the file.
    -   You may NOT add any new classes (you will only be submitting `Radixsort.java`).
    -   You may NOT make any changes to the `Node` class.
    -   You may NOT add any fields to `Radixsort`
    -   You may NOT modify the headers of any of the given methods.
    -   You may NOT delete any methods.
    -   You MAY add helper methods if needed, as long as you make them `private`.

## Running/Testing

Use the class `Sorter` to test your implementation. The project you downloaded contains two sample input files you can use to get started, `radixin1.txt` and `radixin2.txt`. In each of these files, the first line is the radix, and each subsequent line is a number in that radix.

You may assume that you may not be given an empty file, or a file with incorrect format or values. In other words, every file will have a radix in the first line, and at least one following number, so you are not required to make any error checks on the input.

Here's a sample run of `Sorter` on `radixin1.txt`:

```
Enter input file name: radixin1.txt

Sorted Result:
84
222
225
473
862
1569
```

And a sample run on `radixin2.txt`:

```
Enter input file name: radixin2.txt

Sorted Result:
76
786
888
923
765B
A523
C269
```

The sample tests we have given you are just for starters. You will need to create other tests of your own, including other radixes (binary, octal). For every test you run, be careful to keep your test input in the same format as the test files provided. Also, make sure your test file is in the same folder as the other files, i.e. directly under `Radixsort`, otherwise the `Sorter` program will not be able to find your input file.

## Submitting

Submit your `Radixsort.java` source file (NOT `Radixsort.class`).

Refer to the instructions in the Eclipse page, under the section `The Eclipse Workspace` to know how to locate `Radixsort.java` on your computer for uploading.

## Grading Process

Your submission will be auto-graded by a grading script that will run several test cases on each graded method. For each test case, the result computed by your code will be compared with that computed by our correct code. Note that the comparison is based on the state of the fields in the `Radixsort` object, and NOT on anything you might print in your program. (All printed output will be ignored. This also means if you threw in print statements for debugging and left them in your code, they will have no bearing on the grading.)

For your benefit, we will ensure that the methods are graded independent of each other, so that a mistake in the logic in one method will not impact the grading of other methods, all else being equal. What this means is when grading `scatter`, the auto-grader will use correct versions of `createMasterListFromInput` and `gather`, and when grading `gather`, it will use correct versions of `createMasterListFromInput` and `scatter`. (So, for instance, if your `scatter` logic is correct, you will get full credit for it, even if your `createMasterListFromInput` is incorrect. This is because before testing `scatter`, the correct `createMasterListFromInput` code will be used to create the correct master list for `scatter` to work with.)

When grading is done, your test report will be emailed, detailing the score on each test case. Test cases will be posted so you can run your program against them to verify the test report. Remember, verification means checking the state of the `Radixsort` instance fields, NOT what your program might print.
