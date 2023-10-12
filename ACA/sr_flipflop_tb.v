`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:27:20
// Design Name: 
// Module Name: sr_flipflop_tb
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


module sr_flipflop_tb;
    reg s, r, clk;
    wire q, qb;
      
    sr_flip_flop uut(s, r, clk, q, qb);
    initial begin
    #50 clk = 0; s = 1; r = 0;
    #50 s = 0;  r = 0;
    #50 s = 0;  r = 1;
    #50 s = 1;  r = 0;
    #50 s = 1;  r = 1;
    end
    always #5 clk = ~clk;
endmodule
