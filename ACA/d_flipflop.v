`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:44:53
// Design Name: 
// Module Name: d_flipflop
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


module d_flipflop(
    input a, clk,
    output reg q, qb
    );
    
    always@(posedge clk)
    begin
   if(a == 0)
    begin
   q =0; qb = ~q;
   end
   else
    begin
    q = 1; qb = ~q;
    end
    end
endmodule
