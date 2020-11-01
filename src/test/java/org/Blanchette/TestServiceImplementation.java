package org.Blanchette;

import org.Blanchette.exceptions.QuestionInvalide;
import org.Blanchette.impl.ServiceImplementation;
import org.Blanchette.interfaces.Service;
import org.Blanchette.modele.VDQuestion;
import org.junit.Assert;
import org.junit.Test;

public class TestServiceImplementation {
//Testes pour la création d'une question
    @Test
    public void testCréationQuestionValide() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.Contenue = "Bonjour je suis une nouvelle question";
        service.questionsParNombreVotes().clear();
        service.ajoutQuestion(vdQuestion);
        Assert.assertEquals(1,service.questionsParNombreVotes().size() -1);

    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionCourt() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.Contenue = "Lola";
        service.ajoutQuestion(vdQuestion);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionLong() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.Contenue = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        service.ajoutQuestion(vdQuestion);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionId() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.Contenue = "Bonjour je suis une nouvelle question";
        vdQuestion.Id = ""+3;
        service.ajoutQuestion(vdQuestion);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionDouble() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDQuestion vdQuestion2 = new VDQuestion();
        vdQuestion.Contenue = "bonjour je suis une nouvelle questionn";
        vdQuestion2.Contenue = "BONJOUR JE SUIS UNE NOUVELLE QUESTIONN";
        service.ajoutQuestion(vdQuestion);
        service.ajoutQuestion(vdQuestion2);

    }

//Testes pour la création d'un vote


}
