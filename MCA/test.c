#include<lpc214x.h>

void delay();
void main()
{
	IO0DIR |= 0XfffffFFF;
	while(1)
	{
			IOSET0 |= 0XfffffFFF;
			delay();
			IOCLR0 |= 0XFFFfffff;
		  delay();
	}
}

void delay()
{
	unsigned int i;
	for(i = 0; i<30000; i++);
}