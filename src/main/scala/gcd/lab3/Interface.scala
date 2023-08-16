package lab3
import chisel3._
import chisel3.util._
import scala.annotation.switch
class Interface extends Bundle {
val in = Input ( UInt (2. W ) )
val out = Valid ( Output ( UInt (4. W ) ) )
}
class decoder2to4 extends Module {
  val io = IO(new Bundle {
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val out1 = Output(Bool())
     val out2 = Output(Bool())
    val out3 = Output(Bool())
    val out4 = Output(Bool())
  })
  io.out1:=0.B
  io.out2:=0.B
    io.out3:=0.B
      io.out4:=0.B
  
  io.out1 := !io.in1 & !io.in2
 io.out2 := io.in1 & !io.in2
 io.out3 := !io.in1 & io.in2
io.out4 := io.in1 & io.in2
}
class decoder_with_valid extends Module {
val io = IO (new Interface )

   io.out.valid:=0.B
  val d =  Module(new decoder2to4)
  d.io.in1:=io.in(0)
  d.io.in2:=io.in(1)
    io.out.bits:=d.io.out1
   io.out.bits:=d.io.out2
      io.out.bits:=d.io.out3
         io.out.bits:=d.io.out4
  
}