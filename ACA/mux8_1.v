`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 31.08.2023 16:09:35
// Design Name: 
// Module Name: Mux2_1
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


module mux8_1(
    input [2:0]sel, [7:0]i,
    output reg q
    );
    
    always@(*)
    begin
       case(sel)
         3'b000: q = i[0];
         3'b001: q = i[1];
         3'b010: q = i[2];
         3'b011: q = i[3];
         3'b100: q = i[4];
         3'b101: q = i[5];
         3'b110: q = i[6];
         3'b111: q = i[7];       
       endcase
    end   
endmodule
