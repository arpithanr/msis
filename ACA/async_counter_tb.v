`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 15:32:44
// Design Name: 
// Module Name: async_counter_tb
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


module async_counter_tb;

    reg up, clk, rst;
    wire [3:0] count;
    
    async_counter uut(up, clk, rst, count);
    
    initial begin
    
    #50 clk = 0 ; rst = 0; up = 0;
    #10 rst = 1; up = 1;
    #500 rst = 1; up = 0;
    #100 rst = 1; up = 1;
    end
    always #5 clk = ~clk;
endmodule
