package seedu.address.ui.academics;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.academics.Assessment;
import seedu.address.model.academics.Exam;
import seedu.address.model.academics.Homework;
import seedu.address.ui.UiPart;

/**
 * An UI component that displays minimal information of a {@code Assessment}.
 */
public class AssessmentCardExam extends UiPart<Region> {

    private static final String FXML = "AssessmentCardExam.fxml";
    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Assessment assessment;

    @FXML
    private ImageView image;

    @FXML
    private Circle circle;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label description;
    @FXML
    private Label type;
    @FXML
    private Label date;
    @FXML
    private Label submissionTracker;

    /**
     * Constructor to create the assessment card controller.
     */
    public AssessmentCardExam(Assessment assessment, int displayedIndex) {
        super(FXML);
        this.assessment = assessment;
        id.setText(displayedIndex + ". ");
        description.setText(assessment.getDescription());
        if (assessment instanceof Exam) {
            type.setText("Assessment:  Exam");
            date.setText("Exam Date: " + assessment.getDateString());
        }
        submissionTracker.setText("Submissions: " + assessment.noOfSubmittedStudents()
                + "out of" + assessment.getSubmissionTracker().size());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AssessmentCardExam)) {
            return false;
        }

        // state check
        AssessmentCardExam card = (AssessmentCardExam) other;
        return id.getText().equals(card.id.getText())
                && assessment.equals(card.assessment);
    }
}
