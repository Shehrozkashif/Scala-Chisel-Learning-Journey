package practice
import chisel3._
import chisel3.util.MuxLookup
import chisel3.util.Mux1H
import chisel3._

class mux5to1 extends Module {
  val io = IO(new Bundle {
    val select = Input(UInt(3.W))
    val output = Output(UInt(6.W))
  })
  val mux1Result = MuxLookup(io.select, 0.U, Array(
    0.U -> 0.U,
    1.U -> 8.U,
    2.U -> 16.U,
    3.U -> 24.U,
    4.U -> 25.U
  ))

  io.output := mux1Result


}
