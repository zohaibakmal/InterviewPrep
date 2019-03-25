package com.test;

import java.util.*;

public class IBMExam {

    public static void printOutput(String [] input){
        int n = Integer.parseInt(input [0]);
        int p = Integer.parseInt(input [1]);
        int q = Integer.parseInt(input [2]);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<n; i++){
            boolean divisibleByP = i%p==0;
            boolean divisibleByQ = i%q==0;

            if(i!= p && divisibleByP && i!= q && divisibleByQ){
                sb.append("WATSON ");
            }
            else if(i!= p && divisibleByP){
                sb.append("WAT ");
            }else if(i!= q && divisibleByQ){
                sb.append("SON ");
            }else{
                sb.append(i);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());

    }

    private static void process2(String input){
        StringBuilder sb = new StringBuilder();
        LinkedList<String> direction = new LinkedList<>();
        LinkedList<String> time = new LinkedList<>();
        boolean directionFound = false;
        for(int i =0; i<input.length();i++){

            if(!directionFound && Character.isDigit(input.charAt(i))){
                directionFound = true;
                direction.add(sb.toString());
                sb = new StringBuilder();
            }else if(directionFound && Character.isLetter(input.charAt(i))){
                directionFound = false;
                time.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(input.charAt(i));
        }
        if(sb.length()>0){
            time.add(sb.toString());
        }

        int x=0;
        int y=0;
        int z=0;
        int h = 0;

        for(String d: direction){
            int timeValue = Integer.parseInt(time.remove());
            switch (d){
                case "n":
                    y += Math.ceil(150000/(500+z))*timeValue;
                    break;
                case "s":
                    y -= Math.ceil(150000/(500+z))*timeValue;
                    break;
                case "e":
                    x += Math.ceil(150000/(500+z))*timeValue;
                    break;
                case "w":
                    x -= Math.ceil(150000/(500+z))*timeValue;
                    break;
                case "ne":
                    x += Math.ceil(150000/(500+z))*(timeValue)/2;
                    y += Math.ceil(150000/(500+z))*(timeValue)/2;
                    break;
                case "nw":
                    x -= Math.ceil(150000/(500+z))*(timeValue)/2;
                    y += Math.ceil(150000/(500+z))*(timeValue)/2;
                    break;
                case "se":
                    x += Math.ceil(150000/(500+z))*(timeValue)/2;
                    y -= Math.ceil(150000/(500+z))*(timeValue)/2;
                    break;
                case "sw":
                    x -= Math.ceil(150000/(500+z))*(timeValue)/2;
                    y -= Math.ceil(150000/(500+z))*(timeValue)/2;
                    break;
                case "u":
                    z += 60*timeValue;
                    break;
                case "d":
                    z -= 100*timeValue;
                    break;
            }
        }
        System.out.println("("+x+","+y+","+z+")");
    }
    private static void process(String input){
        String [] parts = input.split("\\|");
        HashMap<String, String> map = new HashMap();
        ArrayList<String> result = new ArrayList();
        for (String item: parts){
            String copy = getCleanString(item);
            if(!map.containsKey(copy)){
                for(String subString: result){
                    if(copy.contains(map.get(copy))){
                        result.remove(map.get(subString));
                        result.add(item);

                    }
                }

                result.add(item);
                map.put(copy, item);
            }

        }
    }


    public static boolean isMatch(String s, String p) {
        if(s.length()==0){
            return true;
        }

        if(p.length()==0){
            return false;
        }

        if(p.charAt(0)!='.' && s.charAt(0)!=p.charAt(0)){
            return false;
        }else{
            return isMatch(s.substring(1), p.substring(1));
        }
    }

    private static String getCleanString(String input){
        String copy = input.toLowerCase();
        copy = copy.replaceAll("\\.", "");
        copy = copy.replaceAll(",", ";");
        copy = copy.trim().replaceAll(" +", " ");
        return copy;
    }

    public static void main(String [] args){
        process("watson Represents|watson represents|Watson represents a first step into cognitive systems, a new era of computing.|first step into Cognitive|Cognitive Systems; a new era|what does watson represent");
//        System.out.println(isMatch("aa", "a."));
    }

}
