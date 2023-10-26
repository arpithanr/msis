`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 19.10.2023 14:36:28
// Design Name: 
// Module Name: sequence
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


module sequence(
    input wire clk,reset,
    input wire input_bit,
    output reg[1:0] state,
    output reg out    
    );
       
    always@(posedge clk or posedge reset)
    begin
        if(reset == 0)
        begin
            state <= 2'b00;
            out <=0;
        end
        else
        begin
        case(state)
//            2'b00 :begin if(input_bit) state = 2'b01; else state = 2'b00; end
//            2'b01 :begin if(!input_bit) state = 2'b10;  else state = 2'b00; end
//            2'b10 :begin if(input_bit) state <= 2'b11;  else state = 2'b00; end
//            2'b11 :begin if(!input_bit) begin
//            state <= 2'b00;
//            out <= 1; end
//            out <= 1; end
            2'b00 :begin if(input_bit) state = 2'b01; else state = 2'b00; end
            2'b01 :begin if(!input_bit) state = 2'b10;  else state = 2'b00; end
            2'b10 :begin if(!input_bit) state <= 2'b11;  else state = 2'b00; end
            2'b11 :begin if(input_bit) begin
            state <= 2'b00;
            out <= 1; end
            out <= 1; end
        endcase
        end 
        end 
endmodule
