`timescale 1ns / 1ns
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10.08.2023 15:56:27
// Design Name: 
// Module Name: full_adder_tb
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


module full_adder_tb;
    reg a, b, c;
    wire sum, cout; 
    
    full_adder fa(a, b, c, sum, cout);
    
    initial begin
    a = 0; b = 0; c = 0; #100;
    a = 0; b = 0; c = 1; #100;
    a = 0; b = 1; c = 0; #100;
    a = 0; b = 1; c = 1; #100;
    a = 1; b = 0; c = 0; #100;
    a = 1; b = 0; c = 1; #100;
    a = 1; b = 1; c = 0; #100;
    a = 1; b = 1; c = 1; #100;
    
    end

endmodule
