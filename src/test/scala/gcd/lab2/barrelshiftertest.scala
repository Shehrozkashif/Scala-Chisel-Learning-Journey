package practice

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class barrelshiftertest extends FreeSpec with ChiselScalatestTester{
"Chisel Tester File barrelshifter" in {
    test(new barrelshifter){  a=>
  a.io.A.poke(1.B)
    a.io.B.poke(1.B)
      a.io.C.poke(0.B)
    a.io.D.poke(0.B)
    a.io.shiftsel.poke(1.B)   
    a.io.sel.poke(0.U)   
   
    a.clock.step(1)
    a.io.output1.expect(1.B)
    a.io.output2.expect(1.B)
    a.io.output3.expect(0.B)
    a.io.output4.expect(0.B)
    }



}


}