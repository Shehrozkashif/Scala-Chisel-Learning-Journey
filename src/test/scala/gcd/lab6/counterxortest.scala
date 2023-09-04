package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class counterxortest extends FreeSpec with ChiselScalatestTester {
  "Chisel " in {
    test(new counterxor(3)) { a =>
      a.clock.step(3)
      a.io.out.expect(0.U)
     
    }
  }
}