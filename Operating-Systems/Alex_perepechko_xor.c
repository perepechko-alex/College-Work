#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
	char inputBuffer[4096];
	char keyBuffer[4096];
	
	//input file reading in
    int file_in = open(argv[1], O_RDONLY);
    printf("The file pointer for the input is %d\n", file_in);
	
	//key file reading in
	int file_key = open(argv[2], O_RDONLY);
	printf("The file pointer for the key is %d\n", file_key);
	
	//output file creation
	int file_out = open(argv[3], O_WRONLY | O_CREAT);
	printf("The file pointer for the output is %d\n", file_out);

	//input file size
	struct stat fileStat_in;
	fstat(file_in, &fileStat_in);
	int input_size = fileStat_in.st_size;
    printf("Input File Size: \t\t%d bytes\n", input_size);
	
	//key file size
	struct stat fileStat_key;
	fstat(file_key, &fileStat_key);
	int key_size = fileStat_key.st_size;
    printf("Key File Size: \t\t%d bytes\n", key_size);
    
    

	//read in 4kb Buffer for input
	int input_read = 0;
	
	//read in 4kb Buffer for key
	int key_read = 0;
	
	//for the input while loop
	int input_total = input_read;
	
///////////////////////////////////////////////////////////////////////
	
	//xor
	int dataPosition, keyPosition;
	keyPosition = 0;
	//for the key while look
	int key_total = key_read;
	
	//while true
	while(1)
	{
			input_read = read(file_in, inputBuffer, 4096);
			input_total = input_total + input_read;
			key_read = read(file_key, keyBuffer, 4096);
			key_total = key_total + key_read;
				
		for(dataPosition = 0; dataPosition < 4096; ++dataPosition)
		{
						
			inputBuffer[dataPosition] ^= keyBuffer[keyPosition++];			
		
		if(keyPosition == 4096)
				{
					keyPosition = 0;
				}
			
			//if the whole key is less than 4kb
			else if(keyPosition == key_total || keyPosition == key_size)
			{
				close(file_key);			
				file_key = open(argv[2], O_RDONLY);
				key_read = read(file_key, keyBuffer, 4096);
				key_total = key_total + key_read;
				//printf("The key total %d\n", key_total);

				keyPosition = 0;
			}
		}
		write(file_out, inputBuffer, input_read);
		
		//if the whole file was processed
		if(input_read < 4096)
			break;
		
		//if whole key file was processed
		else if(key_read == key_size)
		{
				close(file_key);
				file_key = open(argv[2], O_RDONLY);			
				key_read = read(file_key, keyBuffer, 4096);
				key_total = key_total + key_read;
	
				keyPosition = 0;
		}
		
	}
	
///////////////////////////////////////////////////////////////////////	

	//output file size
    struct stat fileStat_out;
    fstat(file_out, &fileStat_out);
    int out_size = fileStat_out.st_size;
    printf("Output File Size: \t\t%d bytes\n", out_size);

	close(file_in);
	close(file_key);
	close(file_out);
	
	return 0;
}
