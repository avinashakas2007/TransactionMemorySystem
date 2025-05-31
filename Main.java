//Memory Management System
import java.util.*;
public class Main{
    public static Map<String,String>tempmemomry=new HashMap<>();
    public static Map<String,String>finalmemory=new HashMap<>();
    static int e=1;
    public static void main(String[] args){
        boolean a=true;
        Scanner sc=new Scanner(System.in);
        while(a){
            // System.out.println("Temp");
            // for(String key: tempmemomry.keySet()){
            //     System.out.println(key+" "+tempmemomry.get(key));
            // }
            // System.out.println("Final");
            // for(String key: finalmemory.keySet()){
            //     System.out.println(key+" "+finalmemory.get(key));
            // }
            String select=sc.nextLine();
            String arr[]=select.split(" ");
            switch(arr[0]){
                case "SET":{
                    e=0;
                String variable=arr[1];
                String value=arr[2];
                set(variable,value);
                System.out.println("-------------------");
                break;}
                case "GET":{
                    String variable=arr[1];
                    get(variable);
                    System.out.println("-------------------");
                    break;
                }
                case "UPDATE":{
                    String variable=arr[1];
                    String value=arr[2];
                    update(variable,value);
                    System.out.println("-------------------");
                    break;
                }
                case "UNSET":{
                    String variable=arr[1];
                    unset(variable);
                    System.out.println("-------------------");
                    break;
                }
                case "COUNT":{
                    String value=arr[1];
                    count(value);
                    System.out.println("-------------------");
                    break;
                }
                case "BEGIN":{
                    commit();
                    emptytemp();
                    e=1;
                    System.out.println("-------------------");
                    break;
                }
                case "COMMIT":{
                    commit();
                    System.out.println("-------------------");
                    break;
                }
                case "ROLLBACK":{
                    emptytemp();
                    e=1;
                    System.out.println("-------------------");
                    break;
                }
            }
        }
}
public static void emptytemp(){
    for(String key:tempmemomry.keySet()){
        tempmemomry.put(key, null);
    }
}
public static void set(String var,String val){
    tempmemomry.put(var,val);
}
public static void get(String var){
    if(e==1){
        check(var);
    }
    else if(!tempmemomry.containsKey(var)){
        System.out.println("Variable not found");
    }else{
        System.out.println(tempmemomry.get(var));
    }
}

public static void check(String var){
if(finalmemory.containsKey(var)){
    System.out.println(finalmemory.get(var));
}
else{
    System.out.println("null");
}
}

public static void commit(){
    for(String key:tempmemomry.keySet()){
        if(tempmemomry.get(key)!=null)
        finalmemory.put(key,tempmemomry.get(key));
    }
}

public static void update(String var,String val){
    if(!tempmemomry.containsKey(var)){
        System.out.println("Variable not found");
    }
    else{
        tempmemomry.put(var,val);
    }
}
public static void unset(String var){
    if(!tempmemomry.containsKey(var)){
        System.out.println("Variable not found");
    }else{
        tempmemomry.put(var,null);
    }
}
public static void count(String val){
    int i=0;
    List<String>countlist=new ArrayList<>();
    for(String var : tempmemomry.keySet()){
        if(tempmemomry.get(var).equals(val)){
            i++;
        }
        countlist.add(var);
    }
    for(String var : finalmemory.keySet()){
        if(finalmemory.get(var).equals(val) && !countlist.contains(var)){
            i++;
        }
    }
    if(i==0){
        System.out.println("null");
    }
    else{
        System.out.println(i);
    }
}

}