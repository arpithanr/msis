`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 05.10.2023 09:28:11
// Design Name: 
// Module Name: shift_tb
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


module neg_shift_tb;
reg clk, si,rst,ce;
wire so;
wire[3:0] tmp;

neg_shift uut(clk, ce, si, rst,so,tmp);
initial begin

#10 clk = 0;ce = 1; rst = 0; 
#10  rst = 1; si = 1;
#10 si = 0;
#10 si = 1;
#10 si = 1;
#10 rst = 0;
#150 $finish;
end
always #5 clk = ~clk;
endmodule
