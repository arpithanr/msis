`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 17:03:17
// Design Name: 
// Module Name: t_flipflop_tb
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


module t_flipflop_tb;

    reg t, clk;
    wire q, qb;
      
    t_flipflop uut(t, clk, q, qb);
    initial begin
    #50 clk = 0; t = 1;
    #50 t = 0;
    #50 t = 1;
    #300 $finish;
    end
    always #5 clk = ~clk;
endmodule
