
package lab5
import chisel3._
class Adder(w:Int) extends Module{
    require(w>=0)
    var io=IO(new Bundle{
        var A=Input(UInt(w.W))
        var B=Input(UInt(w.W))
        var sum=Output(UInt(w.W))
    })
    io.sum:= io.A+io.B
}
