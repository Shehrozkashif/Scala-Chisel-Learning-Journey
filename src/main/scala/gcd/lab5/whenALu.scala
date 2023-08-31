package lab5
import chisel3 . _
import chisel3 . util . _
class whenALu( width : Int ) extends Module {
 val io = IO(new Bundle {
     val alu_oper = Input ( UInt ( 4 . W ) )
  val arg_x = Input ( UInt ( width . W ) )
  val arg_y = Input ( UInt ( width . W ) )
  val alu_out = Output ( UInt ( width . W ) )
  })
  io . alu_out := 0. U
  val index = log2Ceil ( 32 )
  print(index)
  when ( io . alu_oper === "b0000". U ) {
    io . alu_out := io . arg_x & io . arg_y
  }
  .elsewhen ( io . alu_oper === "b0001". U ) {
    io . alu_out := io . arg_x | io . arg_y
  }
  .elsewhen ( io . alu_oper === "b0010". U ) {
    io . alu_out := io . arg_x + io . arg_y
  }
  .elsewhen ( io . alu_oper === "b0110". U ) {
    io . alu_out := io . arg_x - io . arg_y
  }
  .elsewhen ( io . alu_oper === "b0011". U ) {
    io . alu_out := io . arg_x ^ io . arg_y
  }   
  .elsewhen ( io . alu_oper === "b0100". U ) {
    io . alu_out := io . arg_x << io . arg_y ( index - 1 , 0 )
  }
  .elsewhen ( io . alu_oper === "b0101". U ) {
    io . alu_out := io . arg_x >> io . arg_y ( index - 1 , 0 )
  }
  .elsewhen ( io . alu_oper === "b0111". U ) {
    io . alu_out := ( io . arg_x . asSInt >> io . arg_y ( index - 1 , 0 ) ) . asUInt
  }
  .elsewhen ( io . alu_oper === "b1000". U ) {
    io . alu_out := io . arg_x . asSInt < io . arg_y . asSInt
  }
  .elsewhen ( io . alu_oper === "b1001". U ) {
    io . alu_out := io . arg_x < io . arg_y
  }
}


