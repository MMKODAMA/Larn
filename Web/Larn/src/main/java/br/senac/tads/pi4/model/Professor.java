package br.senac.tads.pi4.model;

/**
 *
 * @author Larn
 */
public class Professor extends Pessoa {

    private String bio;
    private String lates;
    private String disciplina;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLates() {
        return lates;
    }

    public void setLates(String lates) {
        this.lates = lates;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}
