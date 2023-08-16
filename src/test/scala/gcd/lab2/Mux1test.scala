package practice
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._


class Mux1test extends FreeSpec with ChiselScalatestTester{

"Mux1 test " in{
test (new Mux1 ){ a=>
    
     a.io.A.poke(10.U)  
      a.io.B.poke(20.U)  
      a.io.select.poke(1.B)
    a.clock.step(1)
     a.io.output.expect(20.U)
    
  
}
}

}
