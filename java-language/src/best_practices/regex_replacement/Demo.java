package best_practices.regex_replacement;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        var renderer = new TemplateRenderer();

        String template = "Hi {{ name }}, your order {{orderId}} ships to {{city}}.";
        Map<String, String> vars = Map.of(
                "name", "Alice",
                "orderId", "A-1042"
        );

        // "city" is intentionally missing from vars: getOrDefault falls back
        // to matcher.group() (the original "{{city}}" text), so an unknown
        // placeholder is left untouched instead of silently vanishing.
        System.out.println(renderer.render(template, vars));

        // A replacement value containing regex metacharacters (like $ or \)
        // would corrupt appendReplacement() without Matcher.quoteReplacement,
        // since $ and \ are special in the replacement string too.
        String priceTemplate = "Total: {{ amount }}";
        Map<String, String> priceVars = Map.of("amount", "$1,200 (\\approx)");
        System.out.println(renderer.render(priceTemplate, priceVars));

        // Null/empty inputs are handled gracefully, returning the body as-is.
        System.out.println(renderer.render(template, Map.of()));
    }
}
