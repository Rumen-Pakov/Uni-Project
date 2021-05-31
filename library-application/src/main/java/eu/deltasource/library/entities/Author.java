package eu.deltasource.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Stores information about author, such as name, country, date of birth and date of death.
 */
@Getter
@Setter
@NoArgsConstructor
public class Author {

    private Name name;
    private String country;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public Author(Name name, String country, LocalDate dateOfBirth) {
        this(name, country, dateOfBirth, null);
    }

    public Author(Name name, String country, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        setName(name);
        setCountry(country);
        setDateOfBirth(dateOfBirth);
        setDateOfDeath(dateOfDeath);
    }

    private boolean isDead() {
        return dateOfDeath != null;
    }
}
