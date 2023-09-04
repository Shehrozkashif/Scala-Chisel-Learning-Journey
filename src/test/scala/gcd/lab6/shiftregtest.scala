package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class shiftregtest extends FreeSpec with ChiselScalatestTester
{
"Chisel Tester shiftreg" in {
    test(new shiftreg){  a=>
    a.io.in(0).poke(1.U)
    a.io.in(1).poke(1.U) 
    a.io.in(2).poke(1.U)
    a.io.in(3).poke(1.U)

    a.clock.step(1)
    a.io.out(0).expect(1.U)
    a.io.out(1).expect(1.U)
    a.io.out(2).expect(1.U)
    a.io.out(3).expect(1.U)
    }
}
}
