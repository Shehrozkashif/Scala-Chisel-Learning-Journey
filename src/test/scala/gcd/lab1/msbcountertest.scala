package lab1

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class msbcountertest extends  FreeSpec with  ChiselScalatestTester{
  
"Chisel Tester File"in{
    test(new msbcounter(4))
    { a=>
    a.clock.step(1)
    a.io.result.expect(1.S)
}}} 
