`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 05.10.2023 09:10:56
// Design Name: 
// Module Name: shift
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


module shift(
    input clk, si,rst,
    output so,
    output reg [3:0] tmp
    );
    always@(posedge clk)
    begin 
    if(rst == 0)
        tmp = 4'b0000;
     else
        begin
        tmp <= tmp << 1;
        tmp[0] <= si;
        end
    end
        assign so = tmp[3];
endmodule
