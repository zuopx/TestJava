/**
 * Annotation Configuration for class SpellChecker.
 */

package percy.spring.javabaseddi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpellCheckerConfig
 */
@Configuration
public class SpellCheckerConfig {

  @Bean
  public SpellChecker spellChecker() {
    return new SpellChecker();
  }

}