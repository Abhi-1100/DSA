import java.util.*;

public class JobSequencing {
    static class Job{
        int id;
        int Deadline;
        int profit;

        public Job(int i, int d, int p){
            id=i;
            Deadline=d;
            profit=p;
        }
    }


    public static void main(String[] main){
        int Jobinfo[][]={{4,20},
                         {1,10},
                         {1,40},
                         {1,30}};

        ArrayList<Job> joblist = new ArrayList<>();
        for(int i=0; i<Jobinfo.length; i++){
            joblist.add(new Job(i+1 ,Jobinfo[i][0],Jobinfo[i][1]));
        } 

        Collections.sort(joblist , (obj1,obj2)->obj2.profit-obj1.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time=0;
        int totalprofit=0;
        for(int i=0; i<Jobinfo.length; i++){
            Job curr=joblist.get(i);
            if(curr.Deadline>time){
                time++;
                totalprofit+=curr.profit;
                seq.add(curr.id);
            }
        }
        System.out.println("Max Job under Deadline : "+seq.size());
        System.out.println("Max Profit : "+totalprofit);
        for(int i=0; i<seq.size(); i++){
            System.out.print("J"+seq.get(i)+" ");

        }
    }
    
}
