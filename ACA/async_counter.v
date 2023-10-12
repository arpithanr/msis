`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 15:30:34
// Design Name: 
// Module Name: async_counter
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


module async_counter(
    input up, clk, rst,
    output reg[3:0] count
    );
    always@(posedge clk or negedge rst)
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
