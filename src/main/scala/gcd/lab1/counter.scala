package lab1

import chisel3._
// import chisel3.stage.ChiselStage
// import chisel3.util._

class counter(counterBits: UInt) extends Module {
  val io = IO(new Bundle {
    val result = Output(UInt())
  })

  val max = (1.U<< counterBits) - 1.U
  val count = RegInit(0.U(16.W) ) 

  when(count === max) { 
    count := 0.U
  }.otherwise {
    count := count + 1.U
  }

  io.result :=  max
}