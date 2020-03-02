package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.RemarkG;

import java.util.List;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;


/**
 * Changes the remark of an existing person in the address book.
 */
public class RemarkGCommand extends Command {

    private final Index index;
    private final RemarkG remarkG;

    public static final String MESSAGE_ADD_REMARKG_SUCCESS = "Added remarkG to Person: %1$s";

    public static final String MESSAGE_DELETE_REMARKG_SUCCESS = "Removed remarkG from Person: %1$s";

    public static final String MESSAGE_ARGUMENTS = "Indec: %1$d, Remark: %2$s";

    public static final String COMMAND_WORD = "remarkG";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the remarkG of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing remarkG will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "rG/ [REMARKG]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "rG/ Likes to swim.";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "RemarkG command not implemented yet";

    public RemarkGCommand(Index index, RemarkG remarkG) {
        this.index = index;
        this.remarkG = remarkG;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if(index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(), personToEdit.getAddress(), personToEdit.getRemark(), remarkG, personToEdit.getTags());
        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Generates a command execution success message based on whether the remarkG is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        String message = !remarkG.value.isEmpty() ? MESSAGE_ADD_REMARKG_SUCCESS : MESSAGE_DELETE_REMARKG_SUCCESS;
        return String.format(message, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }

        if(!(other instanceof RemarkGCommand)) {
            return false;
        }

        RemarkGCommand e = (RemarkGCommand) other;
        return index.equals(e.index) && remarkG.equals(e.remarkG);
    }


}