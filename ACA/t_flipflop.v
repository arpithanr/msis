`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 17:01:11
// Design Name: 
// Module Name: t_flipflop
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


module t_flipflop(
    input t, clk,
    output reg q, qb
    );
      always@(posedge clk)
    begin
   if(t == 0)
    begin
   q =1; qb = ~q;
   end
   else
    begin
    q = 0; qb = ~q;
    end
    end
endmodule
