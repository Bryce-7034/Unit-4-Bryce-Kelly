public class Die {
    private int face;

    public Die(){
        roll();
    }

    public int getFace() {
        return face;
    }

    public void  roll(){
        face = (int)(Math.random()*6 + 1);
    }

    public String toString(){
        String result = "";
        result += "face = "+face;
        return result;
    }
}
