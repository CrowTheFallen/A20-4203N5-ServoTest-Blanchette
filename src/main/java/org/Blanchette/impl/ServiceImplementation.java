package org.Blanchette.impl;

import com.github.javafaker.Faker;
import org.Blanchette.exceptions.QuestionInvalide;
import org.Blanchette.exceptions.VoteInvalide;
import org.Blanchette.interfaces.Service;
import org.Blanchette.modele.VDQuestion;
import org.Blanchette.modele.VDVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ServiceImplementation implements Service {
    private List<VDQuestion> questions = new ArrayList<VDQuestion>();
    private List<VDVote> votes = new ArrayList<VDVote>();
    private int idQuestionCompteur;
    private int idVoteCompteur;

    @Override
    public void ajoutQuestion(VDQuestion question) throws QuestionInvalide {
        //Validation
        if(question.id != null) throw new QuestionInvalide();
        if(question.contenue.length() < 5 || question.contenue.length() > 255) throw new QuestionInvalide();
        for (VDQuestion Q: questions) {
            if(question.contenue.toUpperCase().equals(Q.contenue.toUpperCase()) )
                throw new QuestionInvalide();
        }
        //Ajout
        idQuestionCompteur++;
        question.id = "" + idQuestionCompteur;
        questions.add(question);
    }

    @Override
    public void ajoutVote(VDVote vote) throws VoteInvalide {
        //Validation
        if(vote.id != null) throw new VoteInvalide();
        if(vote.vote < 0 || vote.vote > 5) throw new VoteInvalide();
        for (VDQuestion Q: questions) {
            for (VDVote V: votes)
                if(Integer.parseInt(Q.id) == vote.idQuestion){
                    if(vote.nom.toUpperCase().equals(V.nom.toUpperCase()))
                        throw new VoteInvalide();
            }
        }
        //Ajout
        idVoteCompteur++;
        vote.id = "" + idVoteCompteur;
        votes.add(vote);
    }

    @Override
    public List<VDQuestion> questionsParNombreVotes() {
        return new ArrayList<VDQuestion>(questions);
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
        return "Alex Blanchette";
    }
}
