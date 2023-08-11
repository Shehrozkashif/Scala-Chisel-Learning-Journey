package practice

import chisel3._
import chisel3.util.MuxLookup
import chisel3.util.Mux1H
class encoder4to2 extends Module {
  val io = IO(new Bundle {
val in0 = Input ( UInt (4. W ) )
val in1 = Input ( UInt (4. W ) )
val in2 = Input ( UInt (4. W ) )
val in3 = Input ( UInt (4. W ) )
val sel = Input ( UInt (4. W ) )
    val output = Output(UInt(4.W))   
  })
  val encodedResult =  Mux1H ( io.sel , Seq ( io . in0 , io . in1 , io .in2 , io . in3 ) )
  io.output := encodedResult

}
