package lab5 

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class whenALutest extends FreeSpec with ChiselScalatestTester
{
"Chisel Tester File" in {
    test(new whenALu(32)){  a=>
    a.io.arg_x.poke(1.U)
    a.io.arg_y.poke(1.U)  
     a.io.alu_oper.poke(1.U) 
    a.clock.step(2)
    // a.io.alu_out.expect(1.U)

    }

}


}
