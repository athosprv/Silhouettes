Silhouettes

Input:

The input comming in on the BufferedReader consists of an even number of silhouettes with a blank line marking the end of each silhouette.  Each problem consists of a pair of silhouettes.  As usual, you must supply your answer to a problem before continuing on to the next problem, so your code must stop after reading the second blank line which marks the end of the second silhouette and thus the end of a problem.  After answering the problem, your code should continue reading again to get the next problem.

Each silhouette consists of a sequence of integers, one per line followed by a blank line.  As described in class, the numbers indicate alternating x and y coordinates.

Output:

As discussed in class, your output in reply to reading in a pair of silhouettes is the single silhouette that would result from combining/"merging" the two silhouettes.  Your output should be in the same format as the input, namely one integer per line with a blank line marking the end of your answer.

End of Input:

The end of all input will be marked by an additional blank line.  Once this extra blank line is reached on the input, you may return control to the caller of your run function.

Example:

The input for two silhouettes might look like:

9
5
12
7
15
0

3
4
4
0
14
9
17
0


The output would would then look like:

3
4
4
0
9
5
12
7
14
9
17
0


Hint:

The logic to do this correctly for all cases can be subtle.  You might want to consider implementing the following:

Construct a loop that scans the two input silhouettes left to right (analogous to merge for merge sort)
Always look for the "next x" at which one (or both) of the silhouettes changes
At that X value, you will need to know what the Y values are for the two input silhouettes.  The larger Y value will be the Y values in the answer
CAREFUL!!!, that does not mean you automatically output that X,Y to your answer.  If the correct Y value is the same as the last Y value that was placed into the answer, you should not output anything.  In particular consider the two following input silhouettes:
10, 5, 20, 0
20, 5, 30, 0
The answer is:  10, 5, 30, 0    and NOT  10, 5, 20, 5, 30, 0
 

 