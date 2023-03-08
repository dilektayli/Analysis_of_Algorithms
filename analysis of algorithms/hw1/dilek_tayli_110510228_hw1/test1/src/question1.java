import static java.lang.Math.pow;
public class question1 {
    public static void main(String[] args) {
        /** I started from 1 since log(n) cannot have 0 as n. Also, I continued until 50 to show all the possibilities */
        //please check attached word document for detailed solution..!
        for(int i= 1; i<50; i++){
            if(100*i*i<pow(2,i)){
                System.out.println(i);
            }
        }
    }
}