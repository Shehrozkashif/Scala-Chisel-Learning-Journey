package practice
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Mux5to1Test extends FreeSpec with ChiselScalatestTester {
  "Mux 5 to 1 test" in {
    test(new mux5to1) { a =>
      a.io.select.poke(0.U)


      a.clock.step(3)
      a.io.output.expect(0.U)
    }
  }
}





