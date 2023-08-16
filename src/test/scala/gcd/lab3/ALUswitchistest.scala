package lab3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class ALUswitchistest extends FreeSpec with ChiselScalatestTester{
"Chisel Tester ALUswitchistest " in {
    test(new ALUswitchis){  a=>
    a.io.A.poke(1.U)
    a.io.B.poke(1.U)   
     a.io.op.poke(3.U)  
    a.clock.step(1)
a.io.out.expect(2.U)
    }



}
}