#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <time.h>

int main(int argc, char* argv[])
{
	pid_t pid;
	clock_t start_t, end_t;

	int i;
	int j;
	int checksum = 0;
	int status = 0; 
    int file_in = open(argv[1], O_RDONLY);
	int process = atoi(argv[2]);
	
	//input file size
	struct stat fileStat_in;
	fstat(file_in, &fileStat_in);
	int input_size = fileStat_in.st_size;
    
    //read input
    unsigned char processArray[process];
    int CHUNK = input_size/process;
	int remain = input_size%process;
    unsigned char inputBuffer[CHUNK];

	//printf("Starting loop = %ld\n", start_t);
			start_t = clock();
    for (i = 0; i < process; i++)
    {
		file_in = open(argv[1], O_RDONLY);
		pid = fork();
		
	if((pid == 0))
		{
			
			if(process == 1)
				read(file_in,inputBuffer,CHUNK);
			
			else
			{
				 lseek(file_in, i*CHUNK, SEEK_SET);
				 if(i == (process - 1))
					CHUNK = CHUNK + remain;

				 read(file_in, inputBuffer, CHUNK);
			}
			
			for(j = 0; j < CHUNK; j++)
			{
				checksum ^= inputBuffer[j];
			
			}
	
				close(file_in);
				exit(checksum);

		}

	}							
	end_t = clock();

	while((pid = wait(&status)) > 0)
	{				
			processArray[i] = WEXITSTATUS(status);
			checksum^=processArray[i];
	}
    //printf("End of loop = %ld\n", end_t);    
    printf("DEBUG: total clock is = %ld\n", end_t-start_t);

    printf("The final checksum is %d\n", checksum);

	close(file_in);
	return 0;
}
