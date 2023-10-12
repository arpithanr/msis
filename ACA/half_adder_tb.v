`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10.08.2023 09:43:00
// Design Name: 
// Module Name: half_adder_tb
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


module half_adder_tb;
    reg a,b;
    wire sum,co;
    
    half_adder uut(a,b,sum,co);
    initial begin
    a=1'b0;
    b=1'b0;
    a=1'b0;
    b=1'b1;
    a=1'b1;
    b=1'b0;
    a=1'b1;
    b=1'b1;
    end
    initial
    #100 $finish;
endmodule
