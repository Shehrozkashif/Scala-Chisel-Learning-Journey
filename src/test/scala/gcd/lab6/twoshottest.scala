package lab6
package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class twoshottest extends FreeSpec with ChiselScalatestTester
{
"Chisel Tester shiftreg" in {
    test(new twoshot(2)){  a=>
    a.io.trigger.poke(1.B)
    a.io.duration1.poke(1.U)
    a.io.duration2.poke(1.U)

    a.clock.step(1)
   
    a.io.pulse.expect(1.B)
    }
}
}

