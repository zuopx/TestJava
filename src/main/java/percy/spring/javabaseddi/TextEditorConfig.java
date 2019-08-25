/**
 * Annotation configuration for class TextEditor.
 */

package percy.spring.javabaseddi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * TextEditorConfig
 */
@Configuration
@Import(SpellCheckerConfig.class) // access SpellCheckerConfig's beans by @Autowired
public class TextEditorConfig {

  @Bean
  public TextEditor textEditor() {
    TextEditor textEditor = new TextEditor();
    textEditor.setName("notepad++");
    return textEditor;
  }

  // @Bean
  // public SpellChecker spellChecker() {
  //   return new SpellChecker();
  // }
}