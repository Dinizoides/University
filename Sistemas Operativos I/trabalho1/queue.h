#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>

#define INTMIN (-2147483648)

struct Queue; 
struct Queue* createQueue(unsigned capacidade); 
bool isFull(struct Queue* queue);
bool isEmpty(struct Queue* queue);
int SizeQueue(struct Queue* queue);
void enQueue(struct Queue* queue, int item);
int deQueue(struct Queue* queue);
int inicio(struct Queue* queue);
int fim(struct Queue* queue);
