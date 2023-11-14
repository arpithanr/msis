module lshift(
    input clk,si,
    output reg [3:0] so,
    output   temp
    );
    always@(posedge clk)
    begin
    so[0]=si;
    so=so<<1;
    end
    assign temp=so[3];
endmodule
