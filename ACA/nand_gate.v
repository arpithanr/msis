`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 14:41:20
// Design Name: 
// Module Name: nand_gate
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


module nand_gate(
    input a, b,
    output reg f
    );
    
    always@(*)
    begin
    case({a,b})
    2'b00: f = 1;
    2'b01: f = 1;
    2'b10: f = 1;
    default: f = 0;
    endcase
    end
endmodule
