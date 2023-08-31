package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class adderTest extends FreeSpec with ChiselScalatestTester{
    "Chisel "in{
        test(new Adder(32)){a=>
        a.io.A.poke(9.U)    
        a.io.A.poke(5.U)
        a.clock.step(1)
        a.io.sum.expect(14.U)    

        }
    }
}