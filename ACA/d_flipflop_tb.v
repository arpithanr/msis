`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:51:46
// Design Name: 
// Module Name: d_flipflop_tb
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


module d_flipflop_tb;

  reg d, clk;
    wire q, qb;
      
    d_flipflop uut(d, clk, q, qb);
    initial begin
    #50 clk = 0; d = 1;
    #50 d = 0;
    #50 d = 1;
    end
    always #5 clk = ~clk;
endmodule
