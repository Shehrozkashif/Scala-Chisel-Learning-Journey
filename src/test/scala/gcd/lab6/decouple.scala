package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex4test extends FreeSpec with ChiselScalatestTester {
  "Chisel " in {
    test(new decouple) { a =>
            a.io.in1.in.valid.poke(true.B)
            a.io.in1.in.bits.poke(5.U)
            a.io.in1.out.ready.poke(true.B)
            a.clock.step(1)
            a.io.in1.out.valid.expect(true.B)
            a.io.in1.in.ready.expect(true.B)
            a.io.in1.out.bits.expect(5.U)

            a.clock.step(1)
            a.io.in2.out.valid.expect(true.B)
            a.io.in2.in.ready.expect(true.B)
            a.io.in2.out.bits.expect(5.U)
    }
  }
}