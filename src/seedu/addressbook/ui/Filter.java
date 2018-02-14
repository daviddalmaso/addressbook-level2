package seedu.addressbook.ui;

/**
 * Filter of the Text UI.
 */
public class Filter {

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private String commentRegex;

    public Filter() {
        this("#.*");
    }

    public Filter(String commentRegex) {
        this.commentRegex = commentRegex;
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    public boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(commentRegex);
    }

}
