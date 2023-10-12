`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 17.08.2023 08:29:18
// Design Name: 
// Module Name: full_add_beh
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


module full_add_beh(
    input a,b,c,
    output reg sum,co
    );
    
    always@(*)
     begin
     if(a==1'b0&&b==1'b0&&c==1'b0)
     begin
     sum=0;co=0;
     end
     else if(a==1'b0&&b==1'b0&&c==1'b1)
     begin
     sum=1;co=0;
     end
     else if(a==1'b0&&b==1'b1&&c==1'b0)
     begin
     sum=1;co=0;
     end
     else if(a==1'b0&&b==1'b1&&c==1'b1)
     begin
     sum=0;co=1;
     end
     else if(a==1'b1&&b==1'b0&&c==1'b0)
     begin
     sum=1;co=0;
     end
     else if(a==1'b1&&b==1'b0&&c==1'b1)
     begin
     sum=0;co=1;
     end
     else if(a==1'b1&&b==1'b1&&c==1'b0)
     begin
     sum=0;co=1;
     end
    else
    begin
    sum=1;co=1;
    end
    end
     
    
endmodule
