module pregister_tb();
reg clk,si,rst;
wire [3:0]so;
wire [3:0]temp;
pregister uut(clk,si,rst,so,temp);
initial
begin
#10 clk=0;rst=0;
#10 rst=1; si=1;
#10 si=0;
#10 si=1;
#10 si=0;
#60 $finish;
end 
always #5 clk=~clk;

endmodule
