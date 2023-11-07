#include <lpc214x.h>

void delay(unsigned int count);
int main()
{
	IODIR0 = 0xffffffff; //Configure the P0 pins as output;
	
	while(1)
	{
		IOSET0 = 0xffffffff; // Make all port pins as high;
		delay(1000);
		
		IOCLR0 = 0xffffffff; // Make all port pins as low;
		delay(1000);
	}
	return 0;
	
}

void delay(unsigned int count){
	unsigned int i, j;
	for(i = 0; i < count; i++)
	{
		for(j = 0; j < 3000; j++);
	}
	
}