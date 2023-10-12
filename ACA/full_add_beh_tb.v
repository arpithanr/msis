`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 17.08.2023 08:47:08
// Design Name: 
// Module Name: full_add_beh_tb
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


module full_add_beh_tb;
reg a,b,c;
wire sum,co;

full_add_beh uut(a,b,c,sum,co);
initial begin
#10 a=1'b0;b=1'b0;c=1'b0;
#10 a=1'b0;b=1'b0;c=1'b1;
#10 a=1'b0;b=1'b1;c=1'b0;
#10 a=1'b0;b=1'b1;c=1'b1;
#10 a=1'b1;b=1'b0;c=1'b0;
#10 a=1'b1;b=1'b0;c=1'b1;
#10 a=1'b1;b=1'b1;c=1'b0;
#10 a=1'b1;b=1'b1;c=1'b1;
end
initial 
#100 $finish;
endmodule
