import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        //1-etape :creation d'une pipeline vide:notre pipeline est fixe de n thread Sort
        int n=5;
        Sort[] pipeline=new Sort[n];
        //2-etablissement des cannaux
        SynchronousQueue<Integer> I=new SynchronousQueue<Integer>();
        SynchronousQueue<Integer> O=new SynchronousQueue<Integer>();
        for(int i=0;i<n;i++){
            //3-remplissage de la pipeline par n sort
            pipeline[i]=new Sort(i,I,O,n);
            //4-les cannaux du next thread
            I=O;
            out=new SynchronousQueue<Integer>();
            //5-lancement du thread
            pipeline[i].start();

        }



    }
}