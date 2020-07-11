package btech.com.motivation.repository

import btech.com.motivation.infra.MotivationConstants
import java.util.*

class Phrase(val descricao:String,val categoria:Int)

fun Int.random(): Int =  Random().nextInt(this)

class Mock {

    private val ALL = MotivationConstants.FILTRO_FRASE.todos
    private val MORNING = MotivationConstants.FILTRO_FRASE.dia
    private val HAPPY = MotivationConstants.FILTRO_FRASE.feliz

    private  val mListaFrases : List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", MORNING),
        Phrase("Você perde todas as chances que você não aproveita.", MORNING),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", MORNING),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", MORNING),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", MORNING),
        Phrase("Se você acredita, faz toda a diferença.", MORNING),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", MORNING)
    )

    fun getFrase(value : Int) : String{

        val filtrados = mListaFrases.filter { it -> (it.categoria == value || value == ALL) }

        val index = (filtrados.size).random()

        return filtrados[index].descricao
    }
}