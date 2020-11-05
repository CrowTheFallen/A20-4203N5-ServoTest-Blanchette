package org.Blanchette.impl;

import com.github.javafaker.Faker;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.Blanchette.exceptions.QuestionInvalide;
import org.Blanchette.exceptions.VoteInvalide;
import org.Blanchette.interfaces.Service;
import org.Blanchette.modele.VDQuestion;
import org.Blanchette.modele.VDVote;

import java.text.Collator;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
                throw new QuestionInvalide(); }
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
                    if(vote.nom.toUpperCase().equals(V.nom.toUpperCase()) || vote.nom.trim().equals(0))
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
        List<VDQuestion> questionsParVotes = questions;
        List<Integer> nombreDeVote = new ArrayList<Integer>();
        int compteur;
        for (VDQuestion Q: questions){
            compteur = 0;
            for (VDVote V: votes) {
                if(Integer.parseInt(Q.id) == V.idQuestion)
                    compteur++;
            }
            nombreDeVote.add(compteur);
        }
        for (int i = 0; i < nombreDeVote.size() -1; i++) {
            for (int j = 1 + i; j < nombreDeVote.size(); j++) {
                if(nombreDeVote.get(i) < nombreDeVote.get(j)){
                    Collections.swap(questionsParVotes,j,i);
                }
                else if(nombreDeVote.get(i) == nombreDeVote.get(j)){
                    if(questionsParVotes.get(j).contenue.compareTo(questionsParVotes.get(i).contenue) > 0)
                        Collections.swap(questionsParVotes,j,i);
                }
            }
        }
        return questionsParVotes;
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
