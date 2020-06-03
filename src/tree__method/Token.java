package tree__method;

public class Token {
    public enum Type{
        PERCENTAGE_SIGN,
        LEFT_KEY,
        RIGHT_KEY,
        SEMICOLON,
        ARROW_SIGN,
        IDENTIFIER,
        NORMAL_COMENT,
        MULTILINE_COMENT,
        RESERVED_SET,
        REGULAR_EXP,
        PLUS_SIGN,
        ASTERISK_SIGN,
        DOT_SIGN,
        DISJUNTION_SIGN,
        LEFT_QUOTATION_MARK,
        RIGHT_QUOTATION_MARK,
        MACRO_CONJUNTION,
        INPUT_LEXEME,
        QUESTION_MARK,
        TWO_POINTS
    }
    private Type tokenType;
    private String value;
    private int line;
    private int column;
    private int number;
    
    public Token(Type tokenType, String value, int line, int column, int number){
        this.tokenType = tokenType;
        this.value = value;
        this.line = line;
        this.column = column;
        this.number = number;
    }
    
    public String getValue(){
        return value;
    }
    public int getLine(){
        return line;
    }
    public int getColumn(){
        return column;
    }
    public int getNumber(){
        return number;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String toString(){
        return "Number: " + number + ", Column: " + column + ", Line: " + line +", Value: " + value + ", Type: "+ tokenType;
    }
    
    public String getType(){
        switch(tokenType){
            case PERCENTAGE_SIGN:{
                return "PERCENTAGE_SIGN";
            }
            case LEFT_KEY:{
                return "LEFT_KEY";
            }
            case RIGHT_KEY:{
                return "RIGHT_KEY";
            }
            case SEMICOLON:{
                return "SEMICOLON";
            }
            case ARROW_SIGN:{
                return "ARROW_SIGN";
            }
            case IDENTIFIER:{
                return "IDENTIFIER";
            }
            case NORMAL_COMENT:{
                return "NORMAL_COMENT";
            }
            case MULTILINE_COMENT:{
                return "MULTILINE_COMENT";
            }
            case RESERVED_SET:{
                return "RESERVED_SET";
            }
            case REGULAR_EXP:{
                return "REGULAR_EXP";
            }
            case PLUS_SIGN:{
                return "PLUS_SIGN";
            }
            case ASTERISK_SIGN:{
                return "ASTERISK_SIGN";
            }
            case DOT_SIGN:{
                return "DOT_SIGN";
            }
            case DISJUNTION_SIGN:{
                return "DISJUNTION_SIGN";
            }
            case LEFT_QUOTATION_MARK:{
                return "LEFT_QUOTATION_MARK";
            }
            case RIGHT_QUOTATION_MARK:{
                return "RIGHT_QUOTATION_MARK";
            }
            case MACRO_CONJUNTION:{
                return "MACRO_CONJUNTION";
            }
            case INPUT_LEXEME:{
                return "INPUT_LEXEME";
            }
            case QUESTION_MARK:{
                return "QUESTION_MARK";
            }
            case TWO_POINTS:{
                return "TWO_POINTS";
            }
            default:{
                return "UNKNOW_WORD";
            }
        }
    }
}
