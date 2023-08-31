package lab4
import chisel3._
import chisel3.tester._
import org.scalatest._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import lab4.function._
class branchtest extends FreeSpec with ChiselScalatestTester {
  "branch gen" in {
    test(new lab4.branch) { c =>
      // ALU operations
      val array_op = Array(beq, bne, blt, bge, bltu, bgeu)
      for (i <- 0 until 100) { 
        val src_a = Random.nextLong() & 0xFFFFFFFFL
        val src_b = Random.nextLong() & 0xFFFFFFFFL
        val opr = Random.nextInt(6)
        // val aluop = array_op(3)
        val aluop = array_op(opr)

        val result = aluop match {

                    case `beq` => if(src_a.toInt === src_b.toInt) 1.B else 0.B
                    case `bne` => if(src_a.toInt != src_b.toInt) 1.B else 0.B    
                    case `blt` => if(src_a < src_b) 1.B else 0.B
                    case `bge` => if(src_a >= src_b) 1.B else 0.B 
                    case `bltu` => if(src_a < src_b) 1.B else 0.B
                    case `bgeu` => if(src_a >= src_b) 1.B else 0.B 
                    case _ => 0.B
        }
        // val result1: BigInt = if (result < 0L)
        //   (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL
        // else result & 0xFFFFFFFFL
        c.io.A.poke(src_a.U)
        c.io.B.poke(src_b.U)
        c.io.func3.poke(aluop)   // check the opcode and match from above
        c.clock.step(1)
        c.io.out.expect(result)
      }
      c.clock.step(1)
    }
  }
}
