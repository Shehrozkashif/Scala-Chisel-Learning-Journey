package  lab6
import chisel3._
class twoshot(width: Int) extends Module {
  val io = IO(new Bundle {
    val trigger = Input(Bool())   // Input trigger signal
    val pulse = Output(Bool())    // Output pulse signal
    val duration1 = Input(UInt(width.W))  // Duration of the first pulse
    val duration2 = Input(UInt(width.W))  // Duration of the second pulse
  })
  val timer_count = RegInit(0.U(width.W))
  val pulse_active = RegInit(false.B)
  val first_shot = RegInit(true.B)

  val done = timer_count === 0.U
  val next = WireInit(0.U(width.W))

  when(io.trigger) {
    when(first_shot) {
      next := io.duration1 
      first_shot := false.B
    }.otherwise {
      next := io.duration2 
      first_shot := true.B
    }
    pulse_active := true.B
  }.elsewhen(!done) {
    next := timer_count - 1.U 
  }

  timer_count := next

  // Output a pulse when done
  io.pulse := pulse_active && done
}