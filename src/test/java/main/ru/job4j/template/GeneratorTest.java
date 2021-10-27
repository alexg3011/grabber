package main.ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.template.Template;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
public class GeneratorTest {

    @Test
    public void whenGenerate() {
        Template template = new Template();
        Map<String, String> templates = new HashMap<>();
        templates.put("${name}", "Alex");
        templates.put("${subject}", "you");
        String string = "I am a ${name}, Who are ${subject}?";
        String expect = "I am a Alex, Who are you?";
        assertThat(template.produce(string, templates), is(expect));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongTemplate() {
        Template template = new Template();
        Map<String, String> templates = new HashMap<>();
        templates.put("${name}", "Alex");
        templates.put("${subject}", "you");
        String string = "I am a ${name}, Who are ${subject}? My surname is ${surname}";
        template.produce(string, templates);
    }

    @Test(expected = Exception.class)
    public void whenWrongKey() {
        Template template = new Template();
        Map<String, String> templates = new HashMap<>();
        templates.put("${name}", "Alex");
        templates.put("${subject}", "you");
        templates.put("${surname}", "Johnson");
        String string = "I am a ${name}, Who are ${subject}?";
        template.produce(string, templates);
    }

}
