package percy.spring.autowire;

public class TextEditor {

    private String name;
    private SpellChecker spellChecker;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }

    public TextEditor(String name, SpellChecker spellChecker) {
        this.name = name;
        this.spellChecker = spellChecker;
    }

    public TextEditor() {
    }
}