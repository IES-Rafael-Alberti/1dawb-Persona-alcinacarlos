class Persona constructor(var peso: Double, var altura: Double) {
    var nombre: String? = null
        set(value) {
            if (!value.isNullOrBlank()) {
                field = value
            }
        }

    val imc: Double
        get() = peso / (altura * altura)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
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

    println("Persona 1: $persona1")
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")

    print("Nuevo nombre: ")
    persona1.nombre = readln()
    println("Nombre: ${persona1.nombre}, Peso: ${persona1.peso} kg, Altura: ${persona1.altura} m")

    println("Peso: ${persona3.peso} kg, Altura: ${persona3.altura} m, IMC: ${persona3.imc}")
    persona3.altura = 1.80
    println("Peso: ${persona3.peso} kg, Altura: ${persona3.altura} m, IMC: ${persona3.imc}")

    persona2.altura = persona3.altura

    println("Persona 2: $persona2")
    println("Persona 3: $persona3")

    val iguales = persona2 == persona3
    println("Persona 2 y 3 son iguales: $iguales")
}
