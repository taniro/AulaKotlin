open class Veiculo(val modelo:String, val ano:Int){
    open fun acelerar() = "Veículo acelerando..."
}



class Carro (val cor:String, x:String, y:Int):Veiculo(x, y){

    override fun acelerar() = "Carro acelerando"
    override fun toString(): String {
        return "Carro(cor='$cor', modelo='$modelo', ano='$ano')"
    }


}

fun main() {
    var c1:Carro
    c1 = Carro("Corsa", "Preto", 1999)
    println(c1)
    println(c1.modelo)
}