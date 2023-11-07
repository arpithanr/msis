#include <lpc214x.h>

void delay(unsigned int count);
int main()
{
	IODIR0|= (0x01<<16); //Configure Port0.16 pins as output;
	IODIR0&=~(0x01<<14); //Configure Port0.14 as input;
	
	while(1)
	{
		if(IOPIN0&=~(0x01<<14)){
		IOSET0|= (0x01<<16); // Make port0.16 pins as high;
		delay(1000);
		
		IOCLR0|= (0x01<<16); // Make port0.16 pins as low;
		delay(1000);
		}
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