package practice
import chisel3._
import chisel3.util.MuxLookup
class nestedlookup extends Module {
  val io = IO(new Bundle {
    val select1 = Input(UInt(1.W))
    val select2 = Input(UInt(1.W))
     val select3 = Input(UInt(1.W))
    val inputA = Input(UInt(4.W))
    val inputB = Input(UInt(4.W))
    val inputC = Input(UInt(4.W))
    val inputD = Input(UInt(4.W))
     val inputE = Input(UInt(4.W))
    val inputF = Input(UInt(4.W))
    val inputG = Input(UInt(4.W))
    val inputH = Input(UInt(4.W))
    val output = Output(UInt(4.W))
  })

  val mux1Result = MuxLookup(io.select1, false.B, Array(
    0.U -> io.inputA,
    1.U -> io.inputB,
  ))

  val mux2Result = MuxLookup(io.select1, false.B, Array(
    0.U -> io.inputC,
    1.U -> io.inputD,
  ))

  val finalResult1 = MuxLookup(io.select1, false.B, Array(
    0.U -> mux1Result,
    1.U -> mux2Result,
  ))
// 

val mux2_1Result = MuxLookup(io.select1, false.B, Array(
    0.U -> io.inputE,
    1.U -> io.inputF,
  ))

  val mux2_2Result = MuxLookup(io.select1, false.B, Array(
    0.U -> io.inputG,
    1.U -> io.inputH,
  ))

  val finalResult2 = MuxLookup(io.select2, false.B, Array(
    0.U -> mux1Result,
    1.U -> mux2Result,
  ))


val finalResult = MuxLookup(io.select3, false.B, Array(
    0.U -> finalResult1,
    1.U -> finalResult2,
  ))


  io.output := finalResult
}