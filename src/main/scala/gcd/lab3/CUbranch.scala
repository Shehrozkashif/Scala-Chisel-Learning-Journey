package lab3
import chisel3._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is
class CUbranch extends Module {
  val io = IO(new Bundle {
    val A = Input(UInt(32.W))
    val B= Input(UInt(32.W))
   val func3= Input(UInt(4.W))
    val out = Output(Bool())
  })

      io.out :=0.U
      
  util.switch(io.func3) {
    is(1.U) {
      io.out := (io.A === io.B)
    }
    is(2.U) {
      io.out := (io.A =/= io.B)
    }
    is(3.U) {
      io.out := (io.A < io.B)
    }
    is(4.U) {
      io.out :=  (io.A <= io.B)
    }
     is(5.U) {
  
      io.out :=  (io.A > io.B)
    }
     is(6.U) {
      io.out :=  (io.A >= io.B)
    }
    
  }
}