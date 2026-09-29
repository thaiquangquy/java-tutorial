package best_practices.regex_replacement;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Renders {{placeholder}} tokens in a template string using Matcher instead
 * of naive String.replace() calls in a loop -- see the README for why.
 */
public class TemplateRenderer {
    private static final Pattern PLACEHOLDER = Pattern.compile("\\{\\{\\s*(\\w+)\\s*}}");

    public String render(String body, Map<String, String> vars) {
        if (body == null || vars == null || vars.isEmpty()) {
            return body;
        }
        var matcher = PLACEHOLDER.matcher(body);
        var result = new StringBuilder();
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = vars.getOrDefault(key, matcher.group());
            matcher.appendReplacement(result, Matcher.quoteReplacement(value));
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
