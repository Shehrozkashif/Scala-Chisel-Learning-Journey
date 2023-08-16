package lab3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class encoderswitchtest extends FreeSpec with ChiselScalatestTester{
"Chisel Tester encoderswitch" in {
    test(new encoderswitch){  a=>
    //a.io.in1.poke(1.U)
    a.io.in.poke("b00".U)   
    a.clock.step(1)
// a.io.out.expect("b1000".U)
    
    }



}
}