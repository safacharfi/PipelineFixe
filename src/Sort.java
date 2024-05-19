import java.net.CookieHandler;
import java.util.concurrent.SynchronousQueue;

public class Sort extends Thread{
    int index;
    int n;
    int[] res=new int[n];
    SynchronousQueue<Integer> I;
    SynchronousQueue<Integer> O;
    Sort(int index, SynchronousQueue<Integer> I,SynchronousQueue<Integer> O,int n){

    }
    public void run(){
        //Sort 0
        if(index==0){
            //reception du tablau entiere
            int[] tab={2,4,1,5};
            int min=tab[0]; //2
            for(int i=0;i<n;i++){
                if(tab[i]<min){
                    try {
                        O.put(min);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    min=tab[i];
                }
                else{
                    try {
                        O.put(tab[i]);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            res[index]=min;

        }
        if(index>1 && index<n){
            try {
                int min=I.take();//recuperer la 1re valeur recu
                for(int i=0;i<n-index-1;i++){
                    int next=I.take();
                    if(next<min){
                        O.put(min);
                        min=next;
                    }
                    else{
                        O.put(next);
                    }
                }
                res[index]=min;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                int min=I.take();
                res[index]=min;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
