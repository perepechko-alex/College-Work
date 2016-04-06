#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <sys/wait.h>
#define NMACHINES 4
#define KSTATIONS 4

sem_t N_FREE, lock;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int available[NMACHINES] = {1,1,1,1};


pthread_t machineArr[NMACHINES];
pthread_t stationArr[KSTATIONS];

int k;
int m;

void* runMachine(void *m);
void* runStation(void *k);
void release(int machine);
void setup(int stations, int machines)
{
		sem_init(&N_FREE, 0, NMACHINES);
		sem_init(&lock, 0, 1);		
		
		for(k = 0; k < KSTATIONS; k++)
		{
			
			pthread_create(&stationArr[k], NULL, &runStation, (void *)&k);
						//pthread_join(available[stationArr[k]], NULL);
		}
		
		for(m = 0; m < NMACHINES; m++)
		{
			pthread_create(&machineArr[m], NULL, &runMachine,(void *)&m);
						//pthread_join(available[machineArr[m]], NULL);

		}	
	
		

}

void *runMachine(void *ptr)
{
			while(1)
			{
			printf("Machine %d\n\n", m);

			sem_wait(&lock);
			sleep(5);
			release(m);
			sem_post(&lock);

			}
	
					//pthread_exit(0);
}


int allocate()
{

	int i;
	//P(N_FREE);
	sem_wait(&N_FREE);
	//P(lock);
	pthread_mutex_lock(&mutex);
	for(i=0; i < NMACHINES; i++)
	{
		if(available[i] != 0)
		{
			available[i] = 0;
			//V(lock);
			pthread_mutex_unlock(&mutex);
			return i;
		}
	}
	return 0;
}

void release(int machine)
{
	//P(lock);
	pthread_mutex_lock(&mutex);
	available[machine] = 1;
	//V(lock);
	pthread_mutex_unlock(&mutex);
	//V(N_FREE);
	sem_post(&N_FREE);
}

void *runStation(void *ptr)
		{
			while(1)
			{
				allocate();
				printf("Station %d\n\n", k);
				//pthread_exit(0);
			}

		}
		
int main()
{
	setup(KSTATIONS,NMACHINES);
	while(1);
	return 0;
}
