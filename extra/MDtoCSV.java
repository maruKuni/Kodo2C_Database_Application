import java.io.*;
public class MDtoCSV {
    public enum LEVEL{
        LV1,
        LV2,
        LV3,
        LV4,
        LV5W,
        LV5S,
        LV6W,
        LV6S,
        LV7
    };
    public static void main(String[] args) throws IOException {
        MDtoCSV instance = new MDtoCSV(args);
    }
    public MDtoCSV(String[] args) throws IOException{
        for(String fileName : args){
            doConvert(fileName);
        }
    }
    void doConvert(String fileName) throws IOException{
        File input = new File(fileName+".txt");
        File output = new File(fileName+".csv");
        BufferedReader br = new BufferedReader(new FileReader(input));
        PrintWriter pw = new PrintWriter(output);
        
        String str;
        LEVEL lv=LEVEL.LV1;
        String Prefecture="";
        while((str = br.readLine()) != null){
            if(str.charAt(0) == ' '){
                continue;
            }
            switch (getPrefix(str)){
                case 0:
                    for(String area: str.split("[\s]")){
                        pw.println(formatData(Prefecture, lv, fileName, area));
                        pw.flush();
                    }
                    break;
                case 1:
                    Prefecture = str.substring(3);
                    break;
                case 2:
                    lv = strToLevel(str.substring(2));
                    break;
                default:
                break;
            }
            
        }

    }
    LEVEL strToLevel(String level){
        if(level.equals("震度1")){
            return LEVEL.LV1;
        }else if(level.equals("震度2")){
            return LEVEL.LV2;
        }else if(level.equals("震度3")){
            return LEVEL.LV3;
        }else if(level.equals("震度4")){
            return LEVEL.LV4;
        }else if(level.equals("震度5弱")){
            return LEVEL.LV5W;
        }else if(level.equals("震度5強")){
            return LEVEL.LV5S;
        }else if(level.equals("震度6弱")){
            return LEVEL.LV6W;
        }else if(level.equals("震度6強")){
            return LEVEL.LV6S;
        }
        return LEVEL.LV7;
    }
    int getPrefix(String line){
        /*
        0: small area
        1: prefecture
        2: level
        */
        if(line.charAt(0) == '#'){
            if(line.charAt(1) =='#'){
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }
    String formatData(String prefecture, LEVEL lv, String code, String area){
        String ret = code +","+ area+","+ prefecture +"," +Integer.toString(LevelToInteger(lv));
        return ret;
    }
    int LevelToInteger(LEVEL lv){
        switch(lv){
            case LV1:
            return 1;
            case LV2:
            return 2;
            case LV3:
            return 3;
            case LV4:
            return 4;
            case LV5W:
            return 5;
            case LV5S:
            return 6;
            case LV6W:
            return 7;
            case LV6S:
            return 8;
            case LV7:
            return 9;
            default:
            return 1;
        }
    }
}