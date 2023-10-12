`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 24.08.2023 16:51:46
// Design Name: 
// Module Name: d_flipflop_tb
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


module encoder_4_2_tb; 
  reg en;
  reg [3:0]y;
  wire [1:0]a;
      
    encoder uut(en, y, a);
    initial
    begin
    en =0; a =0;
    #20 en=1; a = 4'b0001;
    #20  a = 4'b0010;
    #20;  a = 4'b0100;
    #20;  a = 4'b1000;
    #20
    $finish;   
    end
endmodule
