
package lab6
import chisel3._
import chisel3.util._

class interface1 extends Bundle {
  val in = Flipped(Decoupled(UInt(8.W)))
  val out = Decoupled(UInt(8.W))
}

class interface2 extends Bundle {
  val in = Flipped(Decoupled(UInt(8.W)))
  val out = Decoupled(UInt(8.W))
}

class decouple extends Module {
  val io = IO(new Bundle {
       
   val in1 = new interface2
       val in2 = new interface1
  })

  io.in2.in.ready:=true.B
  val queue1 = Queue(io.in1.in, 5)
  io.in1.out <> queue1

  val queue2 = Queue(queue1, 5)
  io.in2.out <> queue2
}