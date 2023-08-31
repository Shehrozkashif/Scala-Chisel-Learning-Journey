package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class task2test extends FreeSpec with ChiselScalatestTester {
    "Chisel " in {
        test(new router(UInt(32.W))) { a =>
            a.io.in.data.poke(3.U)
            a.io.in.address.poke(2.U)
            a.io.in.valid.poke(true.B)
            a.clock.step(1)

            a.io.out.data.expect(3.U)
            a.io.out.address.expect(2.U)
        }
    }
}
