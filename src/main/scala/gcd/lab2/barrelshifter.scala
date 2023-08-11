
package practice
import chisel3._
import chisel3.util._

class barrelshifter  extends  Module{
  val io = IO(new Bundle{

    val A = Input(Bool())
    val B = Input(Bool())
    val C = Input(Bool())
    val D = Input(Bool())
    val shiftsel = Input(Bool())
       val sel = Input(UInt (2.W))

    val output1 = Output(Bool())
    val output2 = Output(Bool())
    val output3 = Output(Bool())
    val output4 = Output(Bool())
    } ) 

    val muxResult1 = MuxLookup(io.sel, false.B, Array(
    0.U -> io.A,
    1.U -> io.B,
    2.U -> io.C,
    3.U -> io.D,
  ))

    val muxmini1 = MuxLookup(io.shiftsel, false.B, Array(
    0.U -> 0.B,
    1.U -> io.A,
    
  ))
    val muxResult2 = MuxLookup(io.sel, false.B, Array(
    0.U -> io.B,
    1.U -> io.C,
    2.U -> io.D,
    3.U -> muxmini1,
  ))
  
    val muxmini2 = MuxLookup(io.shiftsel, false.B, Array(
    0.U -> 0.B,
    1.U -> io.A,
    
  ))
   val muxmini3 = MuxLookup(io.shiftsel, false.B, Array(
    0.U -> 0.B,
    1.U -> io.B,
    
  ))
 val muxResult3 = MuxLookup(io.sel, false.B, Array(
    0.U -> io.C,
    1.U -> io.D,
    2.U -> muxmini2,
    3.U -> muxmini3,
  ))
 val muxmini4 = MuxLookup(io.shiftsel, false.B, Array(
    0.U -> 0.B,
    1.U -> io.A,
    
  ))
  val muxmini5 = MuxLookup(io.shiftsel, false.B, Array(
    0.U -> 0.B,
    1.U -> io.B,
    
  ))
    val muxmini6 = MuxLookup(io.shiftsel, false.B, Array(
    0.U -> 0.B,
    1.U -> io.C,
    
  ))
  val muxResult4 = MuxLookup(io.sel, false.B, Array(
    0.U -> io.D,
    1.U -> muxmini4,
    2.U -> muxmini5,
    3.U -> muxmini6,
  ))

  io.output1 := muxResult1
 io.output2 := muxResult2
 io.output3 := muxResult3
 io.output4 := muxResult4
}