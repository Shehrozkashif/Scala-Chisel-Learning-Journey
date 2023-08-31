package lab5
import chisel3 . _
class Operator [ T <: Data ]( n : Int , generic : T ) ( op : (T , T ) => T ) extends
Module {
require ( n > 0) // " reduce only works on non - empty Vecs "
val io = IO (new Bundle {
val in = Input ( Vec (n , generic ) )
val out = Output ( Vec (n-1 , generic ) )
})
for(i <- 0 until n-1){

        io.out(i):= op(io.in(i),io.in(i+1))

}
io . out := io . in . reduce ( op )
}


