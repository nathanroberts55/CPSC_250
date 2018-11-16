# Project Description #

For this project, we write Java programs that pull their input data from files using text I/O, write their output data to files using text I/O, and flag their errors using Exceptions.

## Overview ##

The class Matrix contains one method that receives file objects from which to read two matrices containing integer elements. The method multiplies the matrices and writes the result matrix back to a file.

Each of the two input matrices are placed in input files. Each input file contains one line stating the dimensions of the matrix, followed by one line per row containing the elements. For example:

### First Input File ###
    4x2
    1 2
    3 4
    5 6
    7 8

### Second Input File ###
    2x3
    1 2 3
    4 5 6

### Output File ###
    4x3
    9 12 15
    19 26 33
    29 40 51
    39 54 69

## Matrix Multiplication ##

Do not simply attempt to multiply the elements together! Matrix multiplication is performed by mutliplying every element in a given row *R* of the first matrix, by the matching element in a given row *C* of the second matrix. You can follow this video for a detailed description :
[https://www.youtube.com/watch?v=kuixY2bCc_0](https://www.youtube.com/watch?v=kuixY2bCc_0)

For more examples of matrix multiplications, please see the test cases. You can run the numbers manually at [http://www.bluebit.gr/matrix-calculator/matrix_multiplication.aspx](http://www.bluebit.gr/matrix-calculator/matrix_multiplication.aspx).

## Implementation ##

Method *multiply* will scan each input file, read data, perform matrix multiplication, and write the results to a file. The format of this output file will match the example above. Input files will be passed as parameters, as File objects, in order of multiplication. The method must return a File object, which you will need to instantiate. You may give the output file any name you wish when you create the instance of the file object inside the *multiply* method, but you must return the File object you create.

**WARNING**: Do **NOT** attempt to specify a folder for the output file. Simply specify the filename, and let Eclipse put the output file where it will.  Violating this rule will cause the tests to work on your machine, but crash on mine. You are graded on these latter tests.

Whether and how you store the data internally is up to you.  You could use arrays or ArrayLists.  Think through the operations you need, and design useful methods that support your efforts, and reduce code duplication.  Other than *multiply* you are free to design methods as you need them.  I strongly suggest you think through your design on paper before you start coding, and then work out the program flow in comments incrementally.

## Exception Class ##

If at any point the number of tokens is not what is required, or if the dimension of matrices is illegal for multiplication, your method should throw an “IllegalMultiplicationException”. This new exception must be a subclass of “RuntimeException”, and you will need to create the new exception by *extends* 'ing the RuntimeException class.

## Submission ##

Use the same submission techniques as in P1. Fork this workspace, and **keep it private**! Invite your instructor as before. Then clone it, bring it into Eclipse, and add/commit/push as you make progress.  I expect to see many commits to this project over time; code incrementally and at a minimum commit after each increment.
