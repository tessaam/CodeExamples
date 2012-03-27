/* 
* Small program that takes a user inputted key and returns the
* corresponding major and minor scales
*/

#include <stdio.h>

int main (int argc, char** argv) {
	int i, scale;
	char* keyName [12] = {"A","A#","B","C","C#", "D", "D#", "E", "F", "F#", "G", "G#"};
	for (i = 0; i < 12; i++) {
		if (!strcmp(argv[1], keyName[i])){
			scale = i;
			//prints all the steps in the major scale
			printf("%s %s %s %s %s %s %s %s %s\n" , 
				argv[1], "major: ", 
				keyName[step(scale, 2)], 
				keyName[step(scale, 4)], 
				keyName[step(scale, 5)], 
				keyName[step(scale, 7)], 
				keyName[step(scale, 9)], 
				keyName[step(scale, 11)], 
				keyName[step(scale, 12)]);
			
			scale = i;
			//prints all the steps in the minor scale
			printf("%s %s %s %s %s %s %s %s %s\n" , 
				argv[1], "minor: ", 
				keyName[step(scale, 2)], 
				keyName[step(scale, 3)], 
				keyName[step(scale, 5)], 
				keyName[step(scale, 7)], 
				keyName[step(scale, 8)], 
				keyName[step(scale, 10)], 
				keyName[step(scale, 12)]);
		}
	}	
	return 0;
}

//returns an integer that will be used as the index in the keyName array;
//cuts off after 12, the number of notes in keyName array

int step (int increment, int stepAmount){
	if (increment + stepAmount > 11) return increment = (increment + stepAmount - 12);
	else {return increment += stepAmount;}
}


