package org.Blanchette;

import org.Blanchette.exceptions.QuestionInvalide;
import org.Blanchette.exceptions.VoteInvalide;
import org.Blanchette.impl.ServiceImplementation;
import org.Blanchette.interfaces.Service;
import org.Blanchette.modele.VDQuestion;
import org.Blanchette.modele.VDVote;
import org.junit.Assert;
import org.junit.Test;

public class TestServiceImplementation {
//Tests pour la création d'une question
    @Test
    public void testCréationQuestionValide() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        service.ajoutQuestion(vdQuestion);
        Assert.assertNotNull(vdQuestion.id);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionCourt() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.contenue = "Lola";
        service.ajoutQuestion(vdQuestion);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionLong() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.contenue = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        service.ajoutQuestion(vdQuestion);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionId() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        vdQuestion.id = ""+3;
        service.ajoutQuestion(vdQuestion);
    }
    @Test(expected = QuestionInvalide.class)
    public void testCréationQuestionDouble() throws QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDQuestion vdQuestion2 = new VDQuestion();
        vdQuestion.contenue = "bonjour je suis une nouvelle questionn";
        vdQuestion2.contenue = "BONJOUR JE SUIS UNE NOUVELLE QUESTIONN";
        service.ajoutQuestion(vdQuestion);
        service.ajoutQuestion(vdQuestion2);

    }

//Tests pour la création d'un vote
    @Test
    public void testCréationVoteValide() throws VoteInvalide ,QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDVote vdVote = new VDVote();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        service.ajoutQuestion(vdQuestion);
        vdVote.idQuestion = Integer.parseInt(vdQuestion.id);
        vdVote.nom = "Bob";
        vdVote.vote = 3;
        service.ajoutVote(vdVote);
        Assert.assertNotNull(vdVote);
    }
    @Test(expected = VoteInvalide.class)
    public void testCréationVoteDouble() throws VoteInvalide ,QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDVote vdVote = new VDVote();
        VDVote vdVote2 = new VDVote();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        service.ajoutQuestion(vdQuestion);
        vdVote.idQuestion = Integer.parseInt(vdQuestion.id);
        vdVote.nom = "Bob";
        vdVote.vote = 3;
        service.ajoutVote(vdVote);
        vdVote2.idQuestion = Integer.parseInt(vdQuestion.id);
        vdVote2.nom = "Bob";
        vdVote2.vote = 4;
        service.ajoutVote(vdVote2);
    }
    @Test(expected = VoteInvalide.class)
    public void testCréationId() throws VoteInvalide ,QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDVote vdVote = new VDVote();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        service.ajoutQuestion(vdQuestion);
        vdVote.idQuestion = Integer.parseInt(vdQuestion.id);
        vdVote.nom = "Bob";
        vdVote.vote = 3;
        vdVote.id = String.valueOf(16);
        service.ajoutVote(vdVote);
    }
    @Test(expected = VoteInvalide.class)
    public void testCréationTropPetit() throws VoteInvalide ,QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDVote vdVote = new VDVote();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        service.ajoutQuestion(vdQuestion);
        vdVote.idQuestion = Integer.parseInt(vdQuestion.id);
        vdVote.nom = "Bob";
        vdVote.vote = -1;
        service.ajoutVote(vdVote);
    }
    @Test(expected = VoteInvalide.class)
    public void testCréationTropGrand() throws VoteInvalide ,QuestionInvalide {
        Service service = new ServiceImplementation();
        VDQuestion vdQuestion = new VDQuestion();
        VDVote vdVote = new VDVote();
        vdQuestion.contenue = "Bonjour je suis une nouvelle question";
        service.ajoutQuestion(vdQuestion);
        vdVote.idQuestion = Integer.parseInt(vdQuestion.id);
        vdVote.nom = "Bob";
        vdVote.vote = 6;
        service.ajoutVote(vdVote);
    }
}
