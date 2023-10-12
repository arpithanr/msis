`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 15:05:32
// Design Name: 
// Module Name: sync_counter
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


module sync_counter(
    input clk, rst, up,
    output reg[3:0] count
    );
    
    always@(posedge clk)
    begin
    if(rst == 0)
    count = 0;
    else
    begin
    if(up)
        count = count + 1;
        else if(!up)
        count = count - 1;
     end
     end
endmodule
