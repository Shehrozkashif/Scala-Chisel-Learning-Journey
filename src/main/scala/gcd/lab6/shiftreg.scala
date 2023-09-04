package lab6
import chisel3 . _
class shiftreg extends Module {
val io = IO (new Bundle {
val in = Input(Vec(4, UInt(1.W)))
val out = Output(Vec(4, UInt(4.W)))
})
val reg1 = Reg(UInt(1.W))
val reg2 = Reg(UInt(1.W))
val reg3 = Reg(UInt(1.W))
val reg4 = Reg(UInt(1.W))
reg1:=io.in(0)
reg2:=io.in(1)
reg3:=io.in(2)
reg4:=io.in(3)
io . out(0) := reg1
io . out(1) := reg2
io . out(2) := reg3
io . out(3) := reg4
}
 