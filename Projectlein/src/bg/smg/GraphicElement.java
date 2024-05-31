package bg.smg;

public class GraphicElement implements Comparable<GraphicElement> {
    private String img;
    private int size;

    public GraphicElement(String name, int size) {
        this.img = name;
        this.size = size;
    }

    @Override
    public int compareTo(GraphicElement o) {
        if(getSize()>o.getSize()){
            return 1;
        }
        else if(this.getSize()==o.getSize()){
            return 0;
        }
        else {

            return -1;
        }

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
