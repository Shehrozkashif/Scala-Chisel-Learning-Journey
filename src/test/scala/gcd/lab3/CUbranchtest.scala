package lab3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class CUbranchtest extends FreeSpec with ChiselScalatestTester{
"Chisel Tester ALUswitchistest " in {
    test(new CUbranch){  a=>
    a.io.A.poke(0.U)
    a.io.B.poke(0.U)   
     a.io.func3.poke(1.U)  
    a.clock.step(1)
a.io.out.expect(1.B)
    
    }



}
}