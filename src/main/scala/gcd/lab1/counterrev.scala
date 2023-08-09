package lab1
import chisel3._
import chisel3.util._



class counterrev(n: Int) extends Module {
  val io = IO(new Bundle {
    val reload = Input(Bool())
    val out = Output(Bool())
  })

  val counter = RegInit(0.U(n.W))
  val max = n.U(n.W)

  val shouldReload = Wire(Bool())
  val shouldCountDown = Wire(Bool())

  when(counter === max) {
    shouldReload := true.B
    shouldCountDown := true.B
  }.elsewhen(counter === 0.U) {
    shouldReload := true.B
    shouldCountDown := false.B
  }.otherwise {
    shouldReload := false.B
    shouldCountDown := false.B
  }

  when(io.reload) {
    counter := Mux(shouldCountDown, counter - 1.U, counter + 1.U)
  }

  io.out := shouldReload || counter === 0.U
}

