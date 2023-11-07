#include <LPC214x.h>

void delay(int)
int i;
unsigned int a[] = { 0x55, 0xAA};
void main()
IO0DIR = 0 X FFFFFFFF;

while(1){
		for(i = 0; i < 2; i++)
		{
			IO0SET |= a[i];
			delay(50000);
			IO0CLR |= a[i];
			delay(50000);
		}
	}

	void delay(int d){
		unsigned int i;
		for(i = 0; i<d ; i++)
	}
