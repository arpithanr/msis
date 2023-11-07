#include<lpc214x.h>

void pll()
{
  PLL0CON=0X01;
  PLL0CFG=0X24;
  PLL0FEED=0XAA;
  PLL0FEED=0X55;
  while((PLL0STAT&(1<<10))==0);
  PLL0CON=0X03;
  PLL0FEED=0XAA;
  PLL0FEED=0X55;
  VPBDIV=0x01;             //pclk=60mhz
}

void ser_int()
{
  PINSEL0=0X5;
  U0LCR=0X83;
  U0DLL=0x87;
  U0DLM=0x01;
  U0LCR=0X03;
}

void tx(unsigned char c)
{
  while((U0LSR&(1<<5))==0);
  U0THR=c;
}

char rx()
{
  unsigned char a;
  while((U0LSR&(1<<0))==0);
  a=U0RBR;
  return a;
}

void printString(unsigned char data[])
{ int i;
	for(i = 0 ; data[i] != '\0'; i++)
	{
		tx(data[i]);
	}
}

int main(void)
{
 // unsigned char b;
  pll();
  ser_int();
  while(1) {
		printString("Hello");
		tx(10);
	
		//b = rx();
  }
	return 0;
}