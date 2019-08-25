package percy.spring.annotationbaseddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {

    private String name;

    @Autowired
    @Qualifier("spellChecker1")
    private SpellChecker spellChecker;

    public void spellCheck() {
        spellChecker.checkSpelling();
    }

    // @Autowired(required = false)
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

    // @Autowired(required = false)
    public void setName(String name) {
        this.name = name;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    // @Autowired
    // public void setSpellChecker(SpellChecker spellChecker) {
    //     this.spellChecker = spellChecker;
    // }

    @Override
    public String toString() {
        return "TextEditor [name=" + name + ", spellChecker=" + spellChecker + "]";
    }
}