package projektas1;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Studentams
 */
public class Elementas {

    private Studentas pazymys;
    private Elementas kitas;
// Konstruktorius    

    public Elementas(Studentas pazymys, Elementas kitas) {
        if (pazymys == null) {
            throw new NullPointerException();
        }
        this.pazymys = pazymys;
        this.kitas = kitas;
    }

// Metodai   
    public Elementas kitas() {
        return kitas;
    }

    public void keiskKitas(Elementas kitas) {
        this.kitas = kitas;
    }

    public void keiskPazymius(Studentas pazymys) {
        this.pazymys = pazymys;
    }

    public Studentas duomenys() {
        return pazymys;
    }
}

// Klases Elementas pabaiga