`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 05.10.2023 10:24:39
// Design Name: 
// Module Name: neg_shift
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


module neg_shift(
    input clk, ce, si, rst,
    output reg so,
    output reg[3:0]tmp
   
    );
   
    always @(posedge rst or negedge clk)
    begin
        if(ce == 1)
        begin
            if(rst == 0)
                 tmp = 4'b1111;
            else
             begin
                tmp <= tmp << 1;
                tmp[0] <= si;
             end
         end
       so = tmp[3];
    end 
        
   
endmodule
