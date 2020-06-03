package tree__method;

public class Mistake {
    private int line;
    private int column;
    private int number;
    private String mistake;
    private String description;

    public Mistake(int line, int column, int number, String mistake) {
        this.line = line;
        this.column = column;
        this.number = number;
        this.mistake = mistake;
        this.description = "LEXIC_MISTAKE";
    }
    
    public Mistake(){
    }
    
    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMistake() {
        return mistake;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
