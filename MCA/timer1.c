#include <LPC214X.h>
#include "timer.h"

//Initialize the timer for delay
void delay_us(uint32_t us){

		T0CTCR = 0; // Select timer mode
		T0TCR = 0; //Timer/Counter disable
		T0TC = 0; //clear the timer count
		T0PC = 0; // clear the timer prescaler count
		T0TCR = 0X02; // Reset the count
		T0PR = 59; // prescaler register
		T0TCR = 1; // Start the timer
		while(T0TC <us);//check the timer count
		T0TCR = 0; // disable the timer
}

void delay_ms(uint32_t ms){
		T0TCR = 0; //Timer/Counter disable
		T0CTCR = 0; // Select timer mode
		T0PR = 59999;
		T0TC = 0; //clear the timer count
		T0PC = 0; // clear the timer prescaler count
		T0TCR = 1; // Start the timer
		while(T0TC <ms); //chek the timer count
		T0TCR = 0; // disable the timer
}