package org.hbrs.se1.ws24.exercises.uebung4;

public class UserStory implements Comparable<UserStory> {

    private int id;
    private String titel;
    private String akzeptanzKriterien;
    private int aufwand;
    private int risk;
    private int mehrwert;
    private int strafe;
    private double prio;
    private String projekt;

    public UserStory(int id, String titel, String akzeptanzKriterien, int strafe, int aufwand, int risk, String projekt, int mehrwert) {
        this.id = id;
        this.titel = titel;
        this.akzeptanzKriterien = akzeptanzKriterien;
        this.aufwand = aufwand;
        this.risk = risk;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.prio = calculatePriority();
        this.projekt = projekt;
    }


    public double calculatePriority() {
        return (double) (strafe + mehrwert) / (aufwand + risk);
    }
    public double getPrio() {
        return prio;
    }
    public void setPrio(double prio) {
        this.prio = prio;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }
    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }
    public void setAkzeptanzKriterien(String akzeptanzKriterien) {
        this.akzeptanzKriterien = akzeptanzKriterien;
    }
    public String getAkzeptanzKriterien() {
        return akzeptanzKriterien;
    }
    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }
    public String getProjekt() {
        return projekt;
    }

    @Override
    public int compareTo(UserStory other) {
        return Double.compare(other.getPrio(), this.getPrio()); // Absteigende Sortierung nach Priorität
    }
    @Override
    public String toString() {
        return "UserStory{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", akzeptanzKriterien='" + akzeptanzKriterien + '\'' +
                ", aufwand=" + aufwand +
                ", risk=" + risk +
                ", mehrwert=" + mehrwert +
                ", strafe=" + strafe +
                ", prio=" + prio +
                ", projekt='" + projekt + '\'' +
                '}';
    }

}
