`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 31.08.2023 17:36:06
// Design Name: 
// Module Name: mux_4_1_tb
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


module mux8_1_tb();

    reg [2:0]sel;
    reg [7:0]i;
    wire y;
    
    mux8_1 uut(sel, i,y);
    initial begin
    #50 i = 8'b01000100; 
    #50 sel = 3'b000;
    #50 sel = 3'b001;
    #50 sel = 3'b010;
    #50 sel = 3'b011;
    #50 sel = 3'b100;
    #50 sel = 3'b101;
    #50 sel = 3'b110;
    #50 sel = 3'b111;
    #50 i = 8'b11000100; 
    #50 sel = 3'b000;
    #50 sel = 3'b001;
    #50 sel = 3'b010;
    #50 sel = 3'b011;
    #50 sel = 3'b100;
    #50 sel = 3'b101;
    #50 sel = 3'b110;
    #50 sel = 3'b111;
    
    #200; $finish;
    end
endmodule
