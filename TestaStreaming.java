// TestaStreaming.java
public class TestaStreaming {
    public static void main(String[] args) {

        Streaming netflix = new Streaming("Alex", "Premium");

        System.out.println(netflix.toString());

        netflix.assistirFilme("Matrix");
        System.out.println(netflix.toString());

        System.out.println("------------------------");

        netflix.cancelarAssinatura();
        System.out.println(netflix.toString());

        netflix.assistirFilme("O Senhor dos Anéis");
    }
}