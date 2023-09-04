
package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import gcd.lab6.counter3

class counter3test extends FreeSpec with ChiselScalatestTester {
  "Chisel " in {
    test(new counter3) { a =>
        a.io.updown.poke(true.B)
      a.clock.step(5)
     
     
    }
  }
}