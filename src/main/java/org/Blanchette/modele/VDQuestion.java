package org.Blanchette.modele;

import java.util.List;
import java.util.Objects;

public class VDQuestion extends VDVote {
    public String contenue;
    public String id;

    public VDQuestion(){

    }

    public VDQuestion(String contenue){
        this.contenue = contenue;
    }

}
