`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:36:06
// Design Name: 
// Module Name: jk_flipflop
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


module jk_flipflop(
 input j, k, clk,
    output reg q, qb
    );
    
    always@(posedge clk)
    
    begin
    case({j,k})
        2'b00: q = q; 
        2'b01: q = 0;
        2'b10: q = 1;
        2'b11: q = ~q;
        endcase
        qb = ~q;
    end
endmodule
