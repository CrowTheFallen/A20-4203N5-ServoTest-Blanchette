package org.Blanchette.impl;

import org.Blanchette.exceptions.QuestionInvalide;
import org.Blanchette.interfaces.Service;
import org.Blanchette.modele.VDQuestion;
import org.Blanchette.modele.VDVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ServiceImplementation implements Service {
    private static List<VDQuestion> Questions = new ArrayList<VDQuestion>();

    @Override
    public void ajoutQuestion(VDQuestion question) throws QuestionInvalide {
        //Validation
        if(question.Id != null) throw new QuestionInvalide();
        if(question.Contenue.length() < 5 || question.Contenue.length() > 255) throw new QuestionInvalide();
        for (VDQuestion Q: questionsParNombreVotes()) {
            if(question.Contenue.toUpperCase().equals(Q.Contenue.toUpperCase()) )
                throw new QuestionInvalide();
        }
        //Ajout
        int int_random = ThreadLocalRandom.current().nextInt(1,10000000);
        question.Id = "" + int_random;
        Questions.add(question);
    }

    @Override
    public void ajoutVote(VDVote vote) {
        //Validation

        //Ajout

    }

    @Override
    public List<VDQuestion> questionsParNombreVotes() {
        return new ArrayList<VDQuestion>(Questions);
    }

    @Override
    public Map<Integer, Integer> distributionPour(VDQuestion question) {
        return null;
    }

    @Override
    public double moyennePour(VDQuestion question) {
        return 0;
    }

    @Override
    public double ecartTypePour(VDQuestion question) {
        return 0;
    }

    @Override
    public String nomEtudiant() {
        return null;
    }
}
