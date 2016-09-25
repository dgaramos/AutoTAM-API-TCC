package api.autotam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * Created by danilo on 20/09/16.
 */


@Entity
@Table(name= "variavelTAM")
public class VariavelTAM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVariavel")
    private Integer idVariavel;

    @Column(name = "nomeVariavel")
    private String nomeVariavel;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "idAnalise")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Analise analise;

    @OneToMany(mappedBy = "variavelTAM", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Questao> questoes;

    @Column(name = "nota")
    private double nota;

    public VariavelTAM(){}

    public VariavelTAM( String nomeVariavel, Analise analise){
        this.nomeVariavel = nomeVariavel;
        this.analise = analise;
        this.nota = 0;
    }

    public Integer getIdVariavel() {
        return idVariavel;
    }

    public void setIdVariavel(Integer idVariavel) {
        this.idVariavel = idVariavel;
    }

    public String getNomeVariavel() {
        return nomeVariavel;
    }

    public void setNomeVariavel(String nomeVariavel) {
        this.nomeVariavel = nomeVariavel;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VariavelTAM)) return false;

        VariavelTAM that = (VariavelTAM) o;

        if (Double.compare(that.getNota(), getNota()) != 0) return false;
        if (getIdVariavel() != null ? !getIdVariavel().equals(that.getIdVariavel()) : that.getIdVariavel() != null)
            return false;
        if (getNomeVariavel() != null ? !getNomeVariavel().equals(that.getNomeVariavel()) : that.getNomeVariavel() != null)
            return false;
        if (getAnalise() != null ? !getAnalise().equals(that.getAnalise()) : that.getAnalise() != null) return false;
        return getQuestoes() != null ? getQuestoes().equals(that.getQuestoes()) : that.getQuestoes() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getIdVariavel() != null ? getIdVariavel().hashCode() : 0;
        result = 31 * result + (getNomeVariavel() != null ? getNomeVariavel().hashCode() : 0);
        result = 31 * result + (getAnalise() != null ? getAnalise().hashCode() : 0);
        result = 31 * result + (getQuestoes() != null ? getQuestoes().hashCode() : 0);
        temp = Double.doubleToLongBits(getNota());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VariavelTAM{" +
                "idVariavel=" + idVariavel +
                ", nomeVariavel='" + nomeVariavel + '\'' +
                ", analise=" + analise +
                ", questoes=" + questoes +
                ", nota=" + nota +
                '}';
    }
}
