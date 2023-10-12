`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 15:43:02
// Design Name: 
// Module Name: ring_counter
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


module ring_counter(
    input clk, rst,
    output reg [3:0]q
    );
    
    always@(posedge clk)
        if(!rst)
        q = 4'b0001;
        else
        begin
        q[0] <= q[1];
        q[1] <= q[2];
        q[2] <= q[3];
        q[3] <= q[0];
        end
endmodule
