// package lab4

// import chisel3._
// import chisel3.util._
// import org.scalatest._
// import chiseltest._
// import chiseltest.experimental.TestOptionBuilder._
// import scala.util.Random
// import opimm._

// class immgenratortest extends FreeSpec with ChiselScalatestTester {
//   "Chisel" in {
//     test(new immgenrator) { a =>
//       val array_op = Array(I, S, B, U, L, J)
//       val array_ins = Array("b0010011", "b0100011", "b1100011", "b0110111", "b0000011", "b1100111")

//       for (i <- 0 until 100) {
//         val ran = Random.nextInt(6) // Corrected to include all 6 instruction types
//         val op = array_op(ran)
//         val ins = array_ins(ran).U // Converted instruction to UInt

//         val results = op match {
//           case I => Cat(ins(31, 20), Fill(20, 0.U)) // I
//           case S => Cat(Fill(20, 0.U), ins(31, 24), ins(12, 7)) // S
//           case B => Cat(Fill(20, 0.U), ins(11, 8), ins(30, 25), ins(7), ins(31)) // B
//           case U => Cat(Fill(20, 0.U), ins(31, 12)) // U
//           case L => Cat(Fill(20, 0.U), ins(31, 20), Fill(11, 0.U)) // L (placeholder value)
//           case J => Cat(Fill(20, 0.U), ins(31), ins(30, 21), ins(20), ins(19, 12)) // J
//         }
//         a.io.instruction.poke(ins)
//         a.clock.step(1)
//         a.io.imm.expect(results)
//       }
//       a.clock.step(1)
//     }
//   }
// }