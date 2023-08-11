package practice
import chisel3._
import chisel3.util._

class Mux1  extends  Module{
  val io = IO(new Bundle{

    val A = Input(UInt(32.W))
    val B = Input(UInt(32.W))
    val select = Input(Bool())
    val output = Output(UInt(32.W))
  
    } ) 

  val s1 = Fill (32 , io.select.asUInt)
io.output := (io.A & ~s1 | io.B & s1)

}