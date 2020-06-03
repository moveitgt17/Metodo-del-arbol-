package tree__method;

public class Graphviz {
    
    public void GraphvizStructure(){
        try{
            String dotPath = "C:\\Program Files (x86)\\Graphviz 2.28\\bin\\dot.exe";
            String input = "C:\\Users\\CARLOS\\Desktop\\prueba.txt";
            String output = "C:\\Users\\CARLOS\\Desktop\\CHINGAA.jpg";
            String Tparam = "-Tjpg";
            String TOParam = "-o";
            String []cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = Tparam;
            cmd[2] = input;
            cmd[3] = TOParam;
            cmd[4] = output;
            Runtime l = Runtime.getRuntime();
            l.exec(cmd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
