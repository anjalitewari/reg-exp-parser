# reg-exp-parser
Turing machine that parses regular expressions

The program runs on the command line and takes a single argument, the regular expression to parse. 
If the input is invalid, program terminates. If it is a valid regular expression, then it reads lines from standard input, and prints "accept" or "reject" in response to each line.

It handles only the basic regular operations. That is, star, union, and concatenation, and the order of operations is in that order. 
The parser can also handle parentheses and regular expressions defined over {0,1}. 
