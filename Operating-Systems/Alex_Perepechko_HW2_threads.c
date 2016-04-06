#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/wait.h>
#include <time.h>

void *xor(void *ptr);

int main(int argc, char* argv[])
{ 
	pthread_t tid;
	clock_t start_t, end_t;
	
	int i;
	int j;
	int checksum = 0;
	int file_in = open(argv[1], O_RDONLY);
	int thread = atoi(argv[2]);
	//input file size
	struct stat fileStat_in;
	fstat(file_in, &fileStat_in);
	int input_size = fileStat_in.st_size;	
    
    //read input
    unsigned char threadArray[thread];
    
    int CHUNK = input_size/thread;
    int remain = input_size%thread;
    unsigned char inputBuffer[CHUNK];
    
    start_t = clock();
    //printf("Starting loop = %ld\n", start_t);
    for(i = 0; i < thread; i++)
    {	
		if(thread == 1)
				read(file_in,inputBuffer,CHUNK);
			
			else
			{
				 lseek(file_in, i*CHUNK, SEEK_SET);
				  if(i == (thread - 1))
					CHUNK = CHUNK + remain;
				 read(file_in, inputBuffer, CHUNK);
			}
			
			
			 threadArray[i] = checksum;

			void *xor(void *ptr)
			{
				for(j = 0; j < CHUNK; j++)
				{
					checksum ^= inputBuffer[j];
				}
				pthread_exit(0);
			}
			
		pthread_create(&tid, NULL, &xor,(void *)&i);
		pthread_join(tid, NULL);
	}
	end_t = clock();
    //printf("End of loop = %ld\n", end_t);
    printf("DEBUG: total clock is = %ld\n", end_t-start_t);
    
    printf("The final checksum is: %d\n", checksum);

    close(file_in);
    return 0;
}




