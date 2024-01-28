class Persona (var peso: Double, var altura: Double) {
    enum class TipoImc {
        PESO_INSUFICIENTE,
        PESO_SALUDABLE,
        SOBREPESO,
        OBESIDAD
    }

    var nombre: String? = null
        set(value) {
            if (!value.isNullOrBlank()) {
                field = value
            }
        }

    val imc: Double
        get() = peso / (altura * altura)

    private val tipoImc: TipoImc
        get() = obtenerTipoImc()
    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    fun saludar():String{
        return "HOLA, ME LLAMO $nombre"
    }

    private fun alturaEncimaMedia():Boolean{
        return if (altura>=1.75) true else false
    }

    private fun pesoEncimaMedia():Boolean{
        return if (peso>=70.0) true else false
    }
    private fun obtenerTipoImc(): TipoImc {
        return when {
            imc < 18.5 -> TipoImc.PESO_INSUFICIENTE
            imc in 18.5..24.9 -> TipoImc.PESO_SALUDABLE
            imc in 25.0..29.9 -> TipoImc.SOBREPESO
            else -> TipoImc.OBESIDAD
        }
    }

    private fun obtenerDescImc(): String {
        return when (tipoImc) {
            TipoImc.PESO_INSUFICIENTE -> "Peso insuficiente"
            TipoImc.PESO_SALUDABLE -> "Peso saludable"
            TipoImc.SOBREPESO -> "Sobrepeso"
            TipoImc.OBESIDAD -> "Obesidad"
        }
    }
    fun obtenerDesc(){
        val alturamedia = if (alturaEncimaMedia()) "Por debajo de la media" else "Por encima de la media"
        val pedomedio= if (pesoEncimaMedia()) "Por debajo de la media" else "Por encima de la media"

        println("$nombre con una altura de $altura m ($alturamedia) y un peso $peso kg ($pedomedio) tiene un IMC de $imc (${obtenerDescImc()})")
    }
    override fun toString(): String {
        return "Persona(nombre=$nombre, peso=$peso kg, altura=$altura m, imc=$imc)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (peso != other.peso) return false
        if (altura != other.altura) return false
        if (nombre != other.nombre) return false

        return true
    }
}

fun main() {
    val persona1 = Persona(70.5, 1.75)
    val persona2 = Persona("Juan", 65.2, 1.68)
    val persona3 = Persona("Maria", 80.0, 1.75)
    val persona4 = Persona("Lucas", 70.0, 1.85)
    val persona5 = Persona("Julio", 100.2, 2.10)
    val personas = arrayOf(persona5, persona4, persona3, persona2, persona1)
    personas.forEach { it.obtenerDesc() }
}
