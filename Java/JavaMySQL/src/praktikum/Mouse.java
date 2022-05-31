package praktikum;

public class Mouse implements FungsiMouse{
    @Override
    public void klikKiri() {
        System.out.println("Klik kiri");
    }

    @Override
    public void klikKanan() {
        System.out.println("Klik kanan");
    }

    @Override
    public void klikTengah() {

        System.out.println("Klik tengah");
    }
}
