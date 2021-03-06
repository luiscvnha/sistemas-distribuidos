package Ex1;

public class Main implements Runnable {
    private int I;

    public Main(int i) {this.I = i;}

    public void run() {
        for (int i = 1; i <= this.I; ++i)
            System.out.println(i);
    }

    public static void main(String [] args){
        int N = 5,
            I = 4;
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; ++i)
            threads[i] = new Thread(new Main(I));

        System.out.println("Antes");
        for (int i = 0; i < N; ++i)
            threads[i].start();
        System.out.println("Depois");

        try {
            for (int i = 0; i < N; ++i)
                threads[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fim");
    }
}
