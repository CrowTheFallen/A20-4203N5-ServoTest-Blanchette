package org.Blanchette.modele;

import java.util.List;
import java.util.Objects;

public class VDQuestion extends VDVote {
    public String contenue;
    public String id;

    public VDQuestion(){

    }

    public VDQuestion(String contenue){

    }

    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (o == null || getClass() != o.getClass()) return false;
    //    VDQuestion that = (VDQuestion) o;
    //    return Objects.equals(Contenue, that.Contenue) &&
    //            Objects.equals(Id, that.Id);
   // }

  //  @Override
   // public int hashCode() {
   //     return Objects.hash(Contenue, Id);
    //}

   // @Override
   // public String toString() {
   //     return "VDQuestion{" +
    //            "Contenue='" + Contenue + '\'' +
    //            ", Id='" + Id + '\'' +
   //             '}';
    //}
}
