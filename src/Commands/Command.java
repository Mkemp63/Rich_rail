package Commands;

import Logic.Controller;

public abstract class Command {

    Controller cont = Controller.getInstance();

    public abstract void useCommand(String input);
}

/*
grammar RichRail;

command     : newcommand | addcommand | getcommand | delcommand | remcommand;

newcommand : newtraincommand | newwagoncommand;
newtraincommand : 'new' 'train' ID;
newwagoncommand   : 'new' 'wagon' ID ('numseats' NUMBER)?;
addcommand : 'add' ID 'to' ID;
getcommand : 'getnumseats' type ID;
delcommand : 'delete' type ID;
remcommand  : 'remove' ID 'from' ID;

type        : ('train') | ('wagon');
ID          : ('a'..'z')('a'..'z'|'0'..'9')*;
NUMBER            : ('0'..'9')+;
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+;

Examples:
language-words are bold
identifiers are italic
numbers are normal

new train tr1; // response is &ldquo;train tr1 created&rdquo;
new wagon wg1; // response is &ldquo;wagon wg1 created with 20 seats&rdquo;
new wagon wg2 numseats 15; // response is &ldquo;wagon wg2 created with 15 seats&rdquo;
add wg1 to tr1; // response: &ldquo;wagon wg1 added to train tr1&rdquo;
getnumseats train tr1; // response: &ldquo;number of seats in train tr1: 20&rdquo;
getnumseats wagon wg2; // response: &ldquo;number of seats in wagon wg2: 15&rdquo;
delete train tr1; // response: &ldquo;train tr1 deleted&rdquo;
delete train tr2; // response: &ldquo;train tr2 does not exist&rdquo;
remove wg1 from tr1; // response: &ldquo;wagon wg1 removed from train tr1&rdquo;
 */