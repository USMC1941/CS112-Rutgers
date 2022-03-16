/**
 * This class contains a character object, and a double representing its probability of occurrence
 *
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class CharFreq implements Comparable<CharFreq> {
    private Character character;
    private double probOcc;

    public CharFreq() {
        character = 0;
        probOcc = 0;
    }

    public CharFreq(Character c, double p) {
        character = c;
        probOcc = p;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public double getProbOccurrence() {
        return probOcc;
    }

    public void setProbOccurrence(double probOcc) {
        this.probOcc = probOcc;
    }

    public int compareTo(CharFreq cf) {
        Double d1 = probOcc, d2 = cf.probOcc;
        if (d1.compareTo(d2) != 0) {
            return d1.compareTo(d2);
        }
        return character.compareTo(cf.character);
    }
}
