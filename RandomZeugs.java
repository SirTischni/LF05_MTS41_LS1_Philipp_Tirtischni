public class RandomZeugs {

    public static void main(String[] args){
        for(int i=10; i<=20; i=i+1) {
            if (i == 18) break;
            if(i == 11) continue;
            System.out.printf("%d ", i*i);
        }


    }
}
