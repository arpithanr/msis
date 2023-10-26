`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 19.10.2023 15:12:08
// Design Name: 
// Module Name: sequential_tb
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module sequential_tb;
   reg clk, reset;
   reg input_bit;
   wire [1:0]state;
   wire out;
   
   sequence uut(clk, reset, input_bit,state, out);
   initial begin
   #10  reset = 0; clk=0;
//   #10 reset = 1; input_bit = 1;
//   #10 input_bit = 0;
//   #10 input_bit = 1; 
//   #10 input_bit = 0;
//   #70 $finish;
#10 reset = 1; input_bit = 1;
 #10 input_bit = 0;
 #10 input_bit = 0; 
#10 input_bit = 1;
#10 input_bit = 0;
#70 $finish;
   end
   always #5 clk = ~clk;
endmodule
