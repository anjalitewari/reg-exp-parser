# reg-exp-parser
Turing machine that parses regular expressions

The program runs on the command line and takes a single argument, the filename containing a regular expression. 
The program reads lines from standard input, and prints "accept" or "reject" in response to each file.

It handles only the basic regular operations. That is, star, union, and concatenation, and the order of operations is in that order. 
The parser can also handle parentheses and regular expressions defined over {0,1}. 

Sample input can be found in TM1_code.txt and TM2_code.txt and output from running those files in Output.txt.
