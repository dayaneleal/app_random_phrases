package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants

class Phrase(val description: String, val categoryId: Int, val language: String)

class Mock {

    private val sunny = MotivationConstants.FILTER.SUNNY
    private val happy = MotivationConstants.FILTER.HAPPY
    private val all = MotivationConstants.FILTER.ALL

    private val pt = MotivationConstants.LANGUAGE.PT
    private val en = MotivationConstants.LANGUAGE.EN

    private val nListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, pt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy, pt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy, pt),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy, pt),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, pt),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy, pt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, pt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, pt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, pt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, pt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, pt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, pt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny, pt),
        Phrase("Not knowing it was impossible, he went there and did it.", happy, en),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            happy,
            en
        ),
        Phrase("When it's darker, we see more stars!", happy, en),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            happy,
            en
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", happy, en),
        Phrase("What can you do now that has the biggest impact on your success?", happy, en),
        Phrase("The best way to predict the future is to invent it.", sunny, en),
        Phrase("You lose every chance you don't take.", sunny, en),
        Phrase("Failure is the spice that flavors success.", sunny, en),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, en),
        Phrase("If you don't know where you want to go, any way will do.", sunny, en),
        Phrase("If you believe, it makes all the difference.", sunny, en),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            sunny,
            en
        )
    )

    fun getPhrase(mood: Int, lang: String): String{
        return nListPhrase.filter {
            (it.categoryId == mood || mood == all) && it.language ==lang
        }.random().description
    }
}