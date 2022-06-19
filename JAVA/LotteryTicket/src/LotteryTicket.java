import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
 
public class LotteryTicket {
 
    public static void main(String[] args) {
        //前区 33 选6
        List<Integer> redBall = new ArrayList<Integer>();
        for(int i=0;i<33;i++){
            redBall.add(i+1);
        }
        System.out.println("前区号码：" + select(redBall, 6));
        //后区 16选1
        List<Integer> blueBall = new ArrayList<Integer>();  
        for(int i=0;i<16;i++){
            blueBall.add(i+1);
        }
        System.out.println("后区号码：" + select(blueBall, 1));
    }
     
    public static List<Integer> select(List<Integer> list,int count){
        List<Integer> selectedList = new ArrayList<Integer>();
        Random random = new Random();
        for(int i=0;i<count;i++){
            int index = random.nextInt(list.size());
            Integer number = list.get(index);
            selectedList.add(number);
            list.remove(index);
        }
        Collections.sort(selectedList);  
        return selectedList;
    }
 
}
