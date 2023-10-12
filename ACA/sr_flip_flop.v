`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:14:26
// Design Name: 
// Module Name: sr_flip_flop
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


module sr_flip_flop(
    input s, r, clk,
    output reg q, qb
    );
    
    always@(posedge clk)
    
    begin
    case({s,r})
        2'b00: q = q; 
        2'b01: q = 0;
        2'b10: q = 1;
        2'b11: q =1'bz;
        endcase
        qb = ~q;
    end
endmodule
