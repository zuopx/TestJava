package percy.spring.constructordi;

public class TextEditor {

    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellcheck() {
        spellChecker.checkSpelling();
    }
}