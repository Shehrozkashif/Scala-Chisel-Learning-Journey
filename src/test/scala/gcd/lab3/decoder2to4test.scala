package lab3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class decoder2to4test extends FreeSpec with ChiselScalatestTester{
"Chisel Tester decoder2to4" in {
    test(new decoder2to4 ){  a=>
    //a.io.in1.poke(1.U)
    a.io.in1.poke(0.B)   
     a.io.in2.poke(1.B) 
    a.clock.step(1)
a.io.out1.expect(0.B)
     a.io.out2.expect(0.B)
     a.io.out3.expect(1.B)
     a.io.out4.expect(0.B) 
    }

}
}