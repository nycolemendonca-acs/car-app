package app.car.appcarapi.interfaces.incoming.errorhandling;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class LocaleResolver extends AcceptHeaderLocaleResolver {
    private static final Locale DEFAUL_LOCALE = new Locale("pt", "BR");
    private static final List<Locale> ACCEPTED_LOCALES = Arrays.asList(
      DEFAUL_LOCALE,
      new Locale("en")
    );

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        final String acceptLanguageHeader = request.getHeader("Accept-Language");
        if (StringUtils.isEmpty(acceptLanguageHeader) || acceptLanguageHeader.trim().equals("*")) {
            return DEFAUL_LOCALE;
        }

        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(acceptLanguageHeader);
        Locale locale = Locale.lookup(list, ACCEPTED_LOCALES);
        return locale;
    }
}
