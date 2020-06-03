//MODIFY METHOD ADD MISTAKE
//AGREGAR DOS PUNTOS
//AGREGAR CONJUNTO
package tree__method;

import java.util.ArrayList;
import java.util.List;

public class Lexic_Analizer {
    //declaring variables
    private static List<Token> analyzedText;
    private static List<Mistake> mistake;
    private List<String> console;
    private int state,line,column,mistakes,tokenNumber;
    private String auxLexc;
    
    //method that will return the list of tokens from an input
    public List<Token> scanner(String text){
        //initializin variables
        analyzedText = new ArrayList<>();
        mistake = new ArrayList<>();
        console = new ArrayList<>();
        text = text + "#";
        state=0;
        line=1;
        column=0;
        mistakes=0;
        auxLexc="";
        char c;
                
        //this is a loop that will read character by character the input
        for(int i=0; i<=text.length()-1; i++){
            c = text.charAt(i);
            switch(state){
                case 0:{
                        if(Character.isLetter(c)){
                            state = 1;
                            auxLexc += c;
                            column++;
                        }else if(c == '/'){
                            state = 2;
                            auxLexc += c;
                            column++;
                        }else if(c == '"'){
                            state = 3;
                            auxLexc += c;
                            column ++;
                        }else if(c == '%'){
                            auxLexc += c;
                            addToken(Token.Type.PERCENTAGE_SIGN);
                        }else if(c == '{'){
                            auxLexc += c;
                            addToken(Token.Type.LEFT_KEY);
                        }else if(c == '}'){
                            auxLexc += c;
                            addToken(Token.Type.RIGHT_KEY);
                        }else if (c == ';'){
                            auxLexc += c;
                            addToken(Token.Type.SEMICOLON);
                        }else if(c == '-'){
                            state = 4;
                            auxLexc += c;
                            column++;
                        }else if(c == '+'){
                            auxLexc += c;
                            addToken(Token.Type.PLUS_SIGN);
                        }else if(c == '*'){
                            auxLexc += c;
                            addToken(Token.Type.ASTERISK_SIGN);
                        }else if(c == '.'){
                            auxLexc += c;
                            addToken(Token.Type.DOT_SIGN);
                        }else if(c == '|'){
                            auxLexc += c;
                            addToken(Token.Type.DISJUNTION_SIGN);
                        }else if(c == '?'){
                            auxLexc += c;
                            addToken(Token.Type.QUESTION_MARK);
                        }else if(Character.isDigit(c)){
                            state =5;
                            auxLexc += c;
                            column++;
                        }else if(c == ' '){
                            state = 0;
                            column++;
                        }else if(c == '\n'){
                            column = 1;
                            line++;
                            state=0;
                        }else{
                            if(c == '#' && i==text.length()-1){
                                console.add("The lexic analysis has finished succesfully");
                            }else{
                                addMistake(Character.toString(c));
                            }
                        }
                    break;
                }
                case 1:{
                    if(c == ','){
                        state = 6;
                        auxLexc += c;
                        column++;
                    }else if (c=='-'){
                        state = 7;
                        auxLexc += c;
                        column++;
                    }else if(Character.isDigit(c)||Character.isLetter(c)||c=='_'){
                        state = 10;
                        auxLexc += c;
                        column++;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 2:{
                    if(c == '/'){
                        state = 11;
                        auxLexc += c;
                        column++;
                    }else if(c == '!'){
                        state = 12;
                        auxLexc += c;
                        column ++;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 3:{
                    if(c == '"'){
                        auxLexc += c;
                        addToken(Token.Type.INPUT_LEXEME);
                    }else if(c == '\n'){
                        line++;
                        column=0;
                        auxLexc += c;
                    }
                    else{
                        auxLexc += c;
                        column++;
                        state = 3;
                    }
                    break;
                }
                case 4:{
                    if(c=='>'){
                        auxLexc += c;
                        addToken(Token.Type.ARROW_SIGN);
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 5:{
                    if(c=='-'){
                        auxLexc+=c;
                        column++;
                        state =14;
                    }else if(c==','){
                        auxLexc+=c;
                        column++;
                        state =15;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 6:{
                    if(Character.isLetter(c)){
                        auxLexc += c;
                        state = 8;
                        column++;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 7:{
                    if(Character.isLetter(c)){
                        auxLexc += c;
                        addToken(Token.Type.MACRO_CONJUNTION);
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 8:{
                    if(c==','){
                        auxLexc += c;
                        column++;
                        state = 9;
                    }else if(c==';'){
                        addToken(Token.Type.MACRO_CONJUNTION);
                        i -= 1;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 9:{
                    if(Character.isLetter(c)){
                        auxLexc += c;
                        column++;
                        state = 8;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 10:{
                    if(Character.isDigit(c)||Character.isLetter(c)||c=='_'){
                        state = 10;
                        auxLexc += c;
                        column++;
                    }else{
                        addToken(Token.Type.IDENTIFIER);
                        i-=1;
                    }
                    break;
                }
                case 11:{
                    if(c == '\n'){
                        addToken(Token.Type.NORMAL_COMENT);
                    }else{
                        auxLexc += c;
                        column++;
                        state = 1;
                    }
                    break;
                }
                case 12:{
                    if(c=='!'){
                        auxLexc += c;
                        column++;
                        state = 13;
                    }else if(c=='\n'){
                        line++;
                        column=0;
                        auxLexc+=c;
                        state = 12;
                    }else{
                        auxLexc += c;
                        column++;
                        state = 12;
                    }
                    break;
                }
                case 13:{
                    if(c=='/'){
                        auxLexc+=c;
                        addToken(Token.Type.MULTILINE_COMENT);
                    }else{
                        auxLexc+=c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 14:{
                    if(Character.isDigit(c)){
                        auxLexc += c;
                        addToken(Token.Type.MACRO_CONJUNTION);
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 15:{
                    if(Character.isDigit(c)){
                        auxLexc += c;
                        column++;
                        state = 16;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                    break;
                }
                case 16:{
                    if(c==';'){
                        addToken(Token.Type.MACRO_CONJUNTION);
                        i-=1;
                    }else if(c==','){
                        auxLexc += c;
                        column++;
                        state = 15;
                    }else{
                        auxLexc += c;
                        addMistake(auxLexc);
                        auxLexc = "";
                    }
                }
                
            }
        }
        return analyzedText;
    }
    
    public void addToken(Token.Type type){
        if(column==0){
            column++;
        }
        column++;
        analyzedText.add((new Token(type, auxLexc, line, column, tokenNumber)));
        auxLexc = "";
        state = 0;
        tokenNumber++;
        
    }
   
    public List<String> getAux(){
        return console;
    }
    
    public void addMistake(String mista){
        mistake.add((new Mistake(line,column,mistakes,mista)));
        console.add("Mistake with: " + mista);
        mistakes++;
        state = 0;
        column++;
    }
}
