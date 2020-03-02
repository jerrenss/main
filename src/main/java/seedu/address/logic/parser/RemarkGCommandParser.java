package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.RemarkGCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.RemarkG;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARKG;

public class RemarkGCommandParser implements Parser<RemarkGCommand> {
    public RemarkGCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_REMARKG);

        Index index;

        try{
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkGCommand.MESSAGE_USAGE, ive));
        }

        String remarkG = argMultimap.getValue(PREFIX_REMARKG).orElse("");

        return new RemarkGCommand(index, new RemarkG(remarkG));
    }

}
