// package lab4
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class buggedALUtest extends FreeSpec with ChiselScalatestTester {
//   "Chisel Tester ALUswitchistest" in {
//     test(new buggedAlu) { a =>
//       a.io.in_B.poke(0.U)
//       a.io.alu_Op.poke(0.U)

//       a.clock.step(1)

//       a.io.sum.expect(1.U)
//       a.io.out.expect(1.U)
//     }
//   }
// }





