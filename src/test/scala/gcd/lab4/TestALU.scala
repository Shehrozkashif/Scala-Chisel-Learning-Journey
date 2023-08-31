package lab4
import chisel3._
import chisel3.tester._
import org.scalatest._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import lab3.oprate._
class TestALU extends FreeSpec with ChiselScalatestTester {
  "IMM GEN" in {
    test(new lab3.ALUswitchis) { c =>
      // ALU operations
      val array_op = Array(add, sub, and, or, xor, slt, sll, sltu, srl, sra, copyA, copyB)
      for (i <- 0 until 100) { 
        val src_a = Random.nextLong() & 0xFFFFFFFFL
        val src_b = Random.nextLong() & 0xFFFFFFFFL
        val opr = Random.nextInt(12)
        val aluop = array_op(opr)

        val result = aluop match {

          case `add` => src_a + src_b
          case `sub` => src_a - src_b
          case `and` => src_a & src_b
          case `or`  => src_a | src_b
          case `xor` => src_a ^ src_b
          case `slt` => if (src_a < src_b) 1 else 0
          case `sll` => src_a << (src_b & 0x1F)
          case `sltu` => if (src_a < src_b) 1 else 0
          case `srl` => src_a >> (src_b & 0x1F)
          case `sra` => (src_a) >> (src_b & 0x1F)  // toInt and toLong not needed 
          case `copyA` => src_a
          case `copyB` => src_b
          case _ => 0

        }
        val result1: BigInt = if (result < 0L)
          (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL
        else result & 0xFFFFFFFFL
        c.io.A.poke(src_a.U)
        c.io.B.poke(src_b.U)
        c.io.op.poke(aluop)   // check the opcode and match from above
        c.clock.step(1)
        c.io.out.expect(result1.U)

      }
      c.clock.step(1)
    }
  }
}
