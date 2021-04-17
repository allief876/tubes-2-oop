public class MyThread extends Thread {
    String s;

    public MyThread(String str) {
        s = str;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(s);
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
        }
    }
    
}
