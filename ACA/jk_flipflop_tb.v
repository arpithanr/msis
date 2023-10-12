`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:38:55
// Design Name: 
// Module Name: jk_flipflop_tb
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


module jk_flipflop_tb;

    reg j, k, clk;
    wire q, qb;
      
    jk_flipflop uut(j, k, clk, q, qb);
    initial begin
    #50 clk = 0; j = 1; k = 0;
    #50 j = 0;  k = 0;
    #50 j = 0;  k = 1;
    #50 j = 1;  k = 0;
    #50 j = 1;  k = 1;
    end
    always #5 clk = ~clk;
endmodule
