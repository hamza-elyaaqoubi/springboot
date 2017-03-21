package fr.ws.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashSet;
import java.util.Set;

@ConfigurationProperties(prefix = "vcs.aftersale", ignoreUnknownFields= false)
public class AfterSaleProperties {

    private final Vsa vsa = new Vsa();
    private final Cancel cancel = new Cancel();

    public Vsa getVsa() {
        return vsa;
    }

    public Cancel getCancel() {
        return cancel;
    }

    public static class Vsa {
        private String authorisedCountries;

        public String getAuthorisedCountries() {
            return authorisedCountries;
        }

        public void setAuthorisedCountries(String authorisedCountries) {
            this.authorisedCountries = authorisedCountries;
        }
    }

    public static class Cancel {
        private Set<String> authorisedCountries = new HashSet<String>();

        public Set<String> getAuthorisedCountries() {
            return authorisedCountries;
        }

        public void setAuthorisedCountries(Set<String> authorisedCountries) {
            this.authorisedCountries = authorisedCountries;
        }
    }
}
