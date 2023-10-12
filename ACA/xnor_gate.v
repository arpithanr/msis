`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 14:59:28
// Design Name: 
// Module Name: xnor_gate
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


module xnor_gate(
    input a, b,
    output reg f
    );
    always@(*)
    begin
    case({a,b})
    2'b00: f = 1;
    2'b01: f = 0;
    2'b10: f = 0;
    default: f = 1;
    endcase
    end
endmodule
