package gcd.lab6

import chisel3._

class counter3 extends Module {
  val io = IO(new Bundle {
    val updown = Input(Bool())
    val count = Output(UInt(4.W)) 
  })


  val counterReg = RegInit(0.U(4.W))

  when(io.updown) {
    counterReg := counterReg + 1.U
  }.otherwise {
    counterReg := counterReg - 1.U
  }
  io.count := counterReg
}
