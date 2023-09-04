package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import lab1.counterrevtest
class countertest extends FreeSpec with ChiselScalatestTester{
    "Chisel "in{
        test(new counter(4,0)){a=>
    
        a.clock.step(2)
        a.io.out.expect(2.U)    

        }
    }
}