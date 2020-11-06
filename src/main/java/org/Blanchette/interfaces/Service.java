package org.Blanchette.interfaces;

import org.Blanchette.exceptions.*;
import org.Blanchette.modele.VDQuestion;
import org.Blanchette.modele.VDVote;

import java.util.List;
import java.util.Map;

public interface Service {

    void ajoutQuestion(VDQuestion question) throws QuestionInvalide, QuestionInvalideLongueur, QuestionInvalideExistante;

    void ajoutVote(VDVote vote) throws VoteInvalide, VoteInvalideLongueur, VoteInvalideExistant;

    List<VDQuestion> questionsParNombreVotes();

    Map<Integer, Integer> distributionPour(VDQuestion question);

    double moyennePour(VDQuestion question);

    double ecartTypePour(VDQuestion question);

    String nomEtudiant();
}
