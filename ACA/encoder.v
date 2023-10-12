`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 31.08.2023 18:05:23
// Design Name: 
// Module Name: encoder
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


module encoder(
    input [3:0]y,
    input en,
    output reg [1:0]a
    );
    
    always@(*)
    begin
    if(en)
    case(y)
    4'b0001: a = 2'b00;
    4'b0010: a = 2'b01;
    4'b0100: a = 2'b10;
    4'b1000: a = 2'b11; 
    endcase
    else;
    end
endmodule
