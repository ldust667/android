package dleachproductionscom.Gallery;

/**
 * Created by dustin on 2/18/17.
 */
public class Show {


    private int id;
    private String name;

    private byte[] imgsrc;

    public byte[] getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(byte[] imgsrc) {
        this.imgsrc = imgsrc;
    }



    public Show(){


    }


    public Show(String name,byte[] imgsrc){

        this.name=name;
        this.imgsrc=imgsrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void deleteThis(){
        System.exit(0);
        
    }

}
