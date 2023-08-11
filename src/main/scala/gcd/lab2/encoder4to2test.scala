package practice


import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class encoder4to2test extends FreeSpec with ChiselScalatestTester{
"Chisel Tester File encoder vcd" in {
    test(new encoder4to2){  a=>
        
           a.io.in0.poke("b0001".U) // 1
           a.io.in1.poke("b0010".U) // 2
           a.io.in2.poke("b0011".U) // 3 
          a.io.in3.poke("b0100".U) //4
         a.io.sel.poke("b0011".U) //3
         a.clock.step(1)
        a.io.output.expect("b0011".U) //3 
    
    }



}


}