package practice

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class nestedlookuptest extends FreeSpec with ChiselScalatestTester{
"Chisel Tester File" in {
    test(new nestedlookup){  a=>
  a.io.select1.poke(0.U)
    a.io.select2.poke(0.U)
      a.io.select3.poke(0.U)
    a.io.inputA.poke(2.U)
    a.io.inputB.poke(3.U)   
    a.io.inputC.poke(4.U)   
    a.io.inputD.poke(5.U)   
   a.io.inputE.poke(0.U)
    a.io.inputF.poke(1.U)   
    a.io.inputG.poke(3.U)   
    a.io.inputH.poke(4.U) 
    a.clock.step(1)
    a.io.output.expect(2.U)
    
    }



}


}