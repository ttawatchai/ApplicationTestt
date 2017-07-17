package Model;

/**
 * Created by ZIPPER on 7/16/2017.
 */

public class DataApi {

    private String title,des,img;

    public DataApi(String title, String des, String img) {
        this.title = title;
        this.des = des;
        this.img = img;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDes(){
        return des;
    }
    public void setDes(String des){
        this.des=des;
    }
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img=img;
    }
}
