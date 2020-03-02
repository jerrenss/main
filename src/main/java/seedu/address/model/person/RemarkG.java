package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class RemarkG {
    public final String value;

    public RemarkG(String remarkG) {
        requireNonNull(remarkG);
        value = remarkG;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RemarkG // instanceof handles nulls
                && value.equals(((RemarkG) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}