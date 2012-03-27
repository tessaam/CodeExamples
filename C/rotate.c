/* Write a C function that takes in a string s and an int k and 
 * returns a newly allocated string which is the k-fold left rotation 
 * of s. For example, perfoming this operation on "doghouse" and 3 will 
 * return "housedog". Prompt written by Ray Toal.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>  

int main(int argc, char** argv) {
	int nPivot;
	char *strFinal, *p;
	nPivot = atoi(argv[2]);
	if (nPivot > 8) nPivot = nPivot % 8; // if pivot exceeds 8 set it back to however much it exceeds
	if (strlen(argv[1]) > nPivot) {
		strFinal = malloc(strlen(argv[1])); // allocate a destination string that is the size of the source string	
		p = argv[1]; // point at the source string
		p += nPivot; // advance to the pivot point
		strcpy(strFinal, p);  // copies the PostPivot part of the string into the begining of the strFinal string
		*p = 0;  // place a null terminator into the argv[1] string at the pivot point
		strcat(strFinal, argv[1]);
	}			
	printf("%s\n", strFinal);
	free(strFinal);
	return 0;
}

