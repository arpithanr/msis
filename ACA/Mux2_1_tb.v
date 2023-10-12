`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 31.08.2023 16:22:53
// Design Name: 
// Module Name: Mux2_1_tb
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


module Mux2_1_tb;
    reg sel, i0, i1;
    wire y;
    
    Mux2_1 uut(sel, i0, i1, y);
    initial begin
    #10 i0 = 1;
    #10 i1 = 0;
    #10 sel = 0; 
    #10 sel = 1; 
    #200; $finish;
    end
endmodule
