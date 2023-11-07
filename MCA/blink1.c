#include <lpc214x.h>

void delay();
int main()
{
	
	IODIR0 = 0xffffffff; //Configure the P0 pins as output;
	
	while(1)
	{
		IOSET0 = 0xffffffff; // Make all port pins as high;
		delay();
		
		IOCLR0 = 0xffffffff; // Make all port pins as low;
		delay();
	}
	return 0;
	
}

void delay(){
	int i;
	for(i = 0; i < 3000000; i++);
	
}