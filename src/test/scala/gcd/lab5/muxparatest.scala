package lab5 

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class muxparatest extends FreeSpec with ChiselScalatestTester
{
"Chisel Tester Filemuxpara" in {
    test(new muxpara( UInt (2. W ))){  a=>
    a.io.in1.poke(1.U)
    a.io.in2.poke(2.U)  
     a.io.sel.poke(1.B) 
    a.clock.step(2)
    a.io.out.expect(2.U)

    }

}


}
