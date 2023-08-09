
package lab1

import chisel3._
class msbcounter( counterBits:Int )extends  Module{
  
    val io = IO( new Bundle {

    val result = Output( SInt())

    })
    val max = (1.S << counterBits -1) -1.S
    val count = RegInit(0.S (counterBits.W))
    
    when (count === max || count(counterBits -1) === 1.U ){
        count :=0.S
    }
    .otherwise{
        count := count + 1.S
    }
    io. result := count

}


