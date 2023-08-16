package lab3
import chisel3._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is

class ALUswitchis extends Module {
  val io = IO(new Bundle {
    val A = Input(UInt(32.W))
    val B = Input(UInt(32.W))
    val op = Input(UInt(4.W))
    val out = Output(UInt(32.W))
  })

  val shiftamount = io.B(5, 0)
  io.out := 0.U

  util.switch(io.op) {
    is(0.U) {
      io.out := io.A & io.B
    }
    is(1.U) {
      io.out := io.A | io.B
    }
    is(2.U) {
      io.out := io.A - io.B
    }
    is(3.U) {
      io.out := io.A + io.B
    }
    is(4.U) {
      io.out := io.A << shiftamount
    }
    is(5.U) {
      io.out := io.A >> shiftamount
    }
    is(6.U) {
      io.out := (io.A.asSInt >> shiftamount).asUInt
    }
    is(7.U) {
      when(io.A < io.B) {
        io.out := 1.U
      }
    }
    is(8.U) {
      when(io.A.asUInt < io.B.asUInt) {
        io.out := 1.U
      }
    }
    is(9.U) {
      io.out := io.A ^ io.B
    }
  }
}