/**
 * Main app.
 */

package percy.spring.javabaseddi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    // context.register(SpellCheckerConfig.class);
    context.register(TextEditorConfig.class);
    context.refresh();

    TextEditor textEditor = (TextEditor) context.getBean("textEditor");
    System.out.println(textEditor);
    textEditor.spellCheck();

    System.out.println("Done!");
  }
}