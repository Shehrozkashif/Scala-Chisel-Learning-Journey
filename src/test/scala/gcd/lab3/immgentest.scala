package lab3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class immgentest extends FreeSpec with ChiselScalatestTester{
"Chisel Tester immgen " in {
    test(new immgen){  a=>
    a.io.instruction.poke(0.U)
   
    a.clock.step(1)
// a.io.out.expect(1.B)
    
    }

}
}