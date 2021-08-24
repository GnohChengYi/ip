package blue.task;

import blue.BlueException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

/**
 * Tasks that start at a specific time and ends at a specific time.
 */
public class Event extends Task {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private final LocalDateTime at;

    public Event(String title, String atString) throws BlueException {
        super(title);
        try {
            at = LocalDateTime.parse(atString, FORMATTER);
        } catch (DateTimeParseException e) {
            String message = "Please enter a valid date in the correct format, e.g., 2021-12-27T23:59:59";
            throw new BlueException(message);
        }
    }

    /**
     * Returns a String that represents this class.
     *
     * @return String that represents this class.
     */
    public static String getClassRepr() {
        return "E";
    }

    /**
     * Returns the time of the event.
     *
     * @return Time of the event, in String format.
     */
    public String getAt() {
        return at.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * Returns the String representation of this instance.
     *
     * @return String representation of this instance.
     */
    @Override
    public String toString() {
        String atRepr = at.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        return "[E]" + super.toString() + " (at: " + atRepr + ")";
    }
}
