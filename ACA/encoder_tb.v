`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 28.09.2023 10:07:38
// Design Name: 
// Module Name: encoder
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


module encoder_tb;
reg en;
reg [3:0]a;
wire [1:0]y;

encoder_w_p uut(en,a,y);

initial begin

en=0;a=0;
#10 en=1;a=4'b0001;
#10 a=4'b0010;
#10 a=4'b0111;
#10 a=4'b1010;
#100 $finish;
end
endmodule
