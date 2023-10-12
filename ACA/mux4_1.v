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


module mux_4_1(
    input [1:0]sel, [3:0]i,
    output reg q
    );
    
    always@(*)
    begin
       case(sel)
         2'b00: q = i[0];
         2'b01: q = i[1];
         2'b10: q = i[2];
      default: q = i[3];
       endcase
    end   
endmodule
