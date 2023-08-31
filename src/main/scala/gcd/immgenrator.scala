package lab4
import chisel3._
import chisel3.util._

object opimm {
  val I = "b0010011".U(32.W)
  val S = "b0100011".U(32.W)
  val B = "b1100011".U(32.W)
  val U = "b0110111".U(32.W)
  val L = "b0000011".U(32.W)
  val J = "b1100111".U(32.W)
}

import opimm._

class immgenrator extends Module {
  val io = IO(new Bundle {
    val imm = Output(UInt(32.W))
    val instruction = Input(UInt(32.W))
    val out = Output(UInt(12.W))
  })
  io.imm := 0.U
  io.out := 0.U

  val opcode = io.instruction(6, 0)

  switch(opcode) {
    is(I) {
      io.imm := Cat(io.instruction(31, 20), Fill(20, 0.U))
    }
    is(S) {
      io.imm := Cat(Fill(20, 0.U), io.instruction(31, 24), io.instruction(12, 7))
    }
    is(B) {
      io.imm := Cat(Fill(20, 0.U), io.instruction(11, 8), io.instruction(30, 25), io.instruction(7), io.instruction(31))
    }
    is(U) {
      io.imm := Cat(Fill(20, 0.U), io.instruction(31, 12))
    }
    is(J) {
      io.imm := Cat(Fill(20, 0.U), io.instruction(31), io.instruction(30, 21), io.instruction(20), io.instruction(19, 12))
    }
  }
}