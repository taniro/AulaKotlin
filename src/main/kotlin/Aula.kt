import java.time.LocalDate

class Funcionario(var salario:Double, nome:String, altura: Double):Pessoa(nome, altura){

}

open class Pessoa (var nome: String,
            var altura:Double){

    var dataNascimento:LocalDate? = null
    var idade:Int? = null
        private set

    constructor(nome:String, dataNascimento:LocalDate, altura:Double):this(nome, altura){
        this.dataNascimento = dataNascimento
        this.idade = calculaIdade()
    }

    override fun toString() = "$nome ($dataNascimento, $altura, $idade)"
    private fun calculaIdade() = LocalDate.now().year - dataNascimento!!.year
}

class AgendaList(){
    var pessoas = ArrayList<Pessoa>()

    fun armazenaPessoa (p:Pessoa){
        this.pessoas.add(p)
    }

    fun removePessoa (nome:String){
        this.pessoas.removeIf {
            it.nome == nome
        }
    }

    fun buscaPessoa (nome:String):Pessoa?{
        for (p in this.pessoas){
            if (p.nome == nome) return p
        }
        return null
    }

    fun printAgenda(){
        this.pessoas.forEach {
            println(it)
        }
    }

    fun printPessoa(indice:Int){
        println(this.pessoas.elementAtOrNull(indice))
    }

}

class Agenda() {
    var pessoas = arrayOfNulls<Pessoa>(10)

    fun addPessoa(p:Pessoa){
        for (item in pessoas.indices){
            if (pessoas[item] == null){
                pessoas[item] = p
                return
            }
        }
    }

    fun removePessoa(nome:String){

        for (item in pessoas.indices){
            if (pessoas[item]?.nome == nome){
                pessoas[item] = null
            }
        }
    }

    fun printAgenda(){
        for (p:Pessoa? in pessoas){
            println(p.toString())
        }
    }

    fun buscaPessoa(nome:String):Pessoa?{
        for (p:Pessoa? in pessoas)
            if (p?.nome == nome) return p
        return null
    }

    fun printPessoa (index:Int){
        println(pessoas.getOrNull(index))
    }
}

fun main() {
    val a = Pessoa("taniro", LocalDate.of(2000, 12, 10), 1.70)
    println(a.toString())

    val agenda = AgendaList()
    agenda.armazenaPessoa(Pessoa("Taniro", 1.78))
    agenda.armazenaPessoa(Pessoa("Maria", 1.80))
    agenda.armazenaPessoa(Pessoa("Sandro", 1.60))
    agenda.armazenaPessoa(Pessoa("Thiago", 1.20))

    agenda.printAgenda()

    agenda.printPessoa(10)

    println(agenda.buscaPessoa("Taniro"))
    println(agenda.buscaPessoa("Pedro"))

    agenda.removePessoa("Taniro")
    agenda.removePessoa("Pedro")

    println(agenda.buscaPessoa("Taniro"))
    println(agenda.buscaPessoa("Pedro"))



}