package percy.spring.javabaseddi;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

    private String name;

    @Autowired(required = false)
    private SpellChecker spellChecker;

    public void spellCheck() {
        spellChecker.checkSpelling();
    }

    public TextEditor(String name, SpellChecker spellChecker) {
        System.out.println("Inside TextEditor constructor.");
        this.name = name;
        this.spellChecker = spellChecker;
    }

    public TextEditor() {
        System.out.println("Inside default TextEditor constructor.");
    }

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

    @Override
    public String toString() {
        return "TextEditor [name=" + name + ", spellChecker=" + spellChecker + "]";
    }
}