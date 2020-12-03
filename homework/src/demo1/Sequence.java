package demo1;

/**
 * 打印斐波拉契数列前20位
 */
public class Sequence {
    public static void main(String[] args) {
        int[] sequence=new int[20];
        for(int i=0;i<20;i++){
            if(i<2){
                sequence[i]=1;
            }else{
                sequence[i]=sequence[i-1]+sequence[i-2];
            }
        }
        System.out.println("斐波拉契数列前20位如下：");
        for (int n:sequence) {
            System.out.print(n+" ");
        }
    }
}
