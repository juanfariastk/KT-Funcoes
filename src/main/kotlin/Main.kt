/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplinaPosicional(materia: String, notas: MutableList<Double>): Boolean {
    if (materiasENotas.size < 3) {
        materiasENotas[materia] = notas
        return true
    }
    return false
}
/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


//mostrarNotas



fun adicionarDisciplinaNomeada(materia: String, vararg notas: Double): Boolean {
    if (materiasENotas.size < 3) {
        materiasENotas[materia] = notas.toMutableList()
        return true
    }
    return false
}

// adicionar disciplina:

fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    if (materiasENotas.size < 3) {
        materiasENotas[materia] = notas
        return true
    }
    return false
}


//Disciplinas sem notas

fun adicionarDisciplinaSemNotas(materia: String): Boolean {
    if (materiasENotas.size < 3) {
        materiasENotas[materia] = mutableListOf()
        return true
    }
    return false
}

//AC


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia: String) {
    val notasDaMateria = materiasENotas[materia] ?: return

    println("Matéria: $materia")
    var cont = 1
    for (nota in notasDaMateria) {
        println("Nota ${cont++}: $nota")
    }

    val media = calcularMedia(notasDaMateria)
    println("Média: $media")

    println()
}

//calcular média

fun calcularMedia(notas: List<Double>): Double {
    if (notas.isEmpty()) return 0.0

    var soma = 0.0
    for (nota in notas) {
        soma += nota
    }

    return soma / notas.size
}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val notasDaMateria = materiasENotas[materia] ?: return false
    notasDaMateria.addAll(notas.toMutableList())
    return true
}


fun main() {

    // Adicionando disciplinas com diferentes métodos:

    adicionarDisciplinaPosicional("Matemática", mutableListOf(8.5, 7.0, 9.5))
    adicionarDisciplinaNomeada("Física", 7.8, 9.2, 8.5)
    adicionarDisciplinaSemNotas("História")

    // Adicionando notas:

    adicionarNota("Matemática", 10.0)
    adicionarVariasNotas("Física", 6.5, 8.0)

    // Mostrando notas:

    mostrarNotas("Matemática")
    mostrarNotas("Física")
    mostrarNotas("História")

    // Adicionando e mostrando notas de uma nova disciplina:

    adicionarDisciplina("Biologia")
    adicionarVariasNotas("Biologia", 8.0, 7.5, 9.0)
    mostrarNotas("Biologia")
}

