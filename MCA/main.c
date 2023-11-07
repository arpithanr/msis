#include <LPC214x.h>
#include "timer.h"
#include "pll_init.h"

int main(void){
	/*init_PLL();
	PINSEL0 = 0;
	IO0DIR |= (0x01 << 2) | (0x01 << 07);
	while(1){
	IO0SET |= (0x01 << 2) | (0x01 << 07);//0X01; //SET P0.0 to high
	delay_ms(100); // delay 100ms
	IO0CLR |= (0x01 << 2) | (0x01 << 07);//0x01; //set p0.0 to low
	delay_ms(100);// delay 100ms
	}
	return 0; */

	IO0DIR |= (0x01 << 15); 
	IO0DIR &= ~LED_PIN;
	IO0SET |= LED_PIN;
	init_PLL();
	PINSEL0 = 0;
	while(1){
	if((IO0PIN & LED_PIN)){
	IO0SET |= (0x01 << 15);
	delay_ms(100); // delay 100ms
	}
	else{
	IO0CLR |= (0x01 << 15);
	delay_ms(100);// delay 100ms
	}
}
	return 0; 

}
