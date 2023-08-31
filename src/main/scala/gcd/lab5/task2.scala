package lab5
import chisel3._
import chisel3.util._

class packet1[T <: Data](gen: T) extends Bundle {
val address=Input(UInt(32.W))
    val data=gen.cloneType
    val valid= Input(Bool())
}

class packet2[T <: Data](gen: T) extends Bundle {
 val address=Input(UInt(32.W))
    val data=gen.cloneType
    val valid= Input(Bool())
}
class router[T<: Data](gen: T) extends Module{
    val io=IO(new Bundle{
        val in=Input(new packet1(gen))
        val out=Output(new packet2(gen))
    })
    io.out.data := 0.U
    io.out.address :=0.U
    io.out.valid:=0.U
    when (io.in.valid){
        io.out.data := io.in.data
        io.out.address := io.in.address
        io.out.valid:=io.in.valid
    }
}