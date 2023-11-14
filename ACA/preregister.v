module pregister(
    input clk,si,rst,
    output [3:0] so,
    output reg[3:0]temp
    );
    always@(posedge clk)
    begin 
    if(rst==0)
        temp=4'b0000;
    else
    temp <=temp<<1;
    temp <=si;
    end
        assign so=temp;
endmodule
