package Bayes;

public class BayesBean
{
    private String color; //色泽
    private String root; //根蒂
    private String sound;//敲声
    private String vein;//纹理
    private String navel;//脐部
    private String touch;//触感
    private Boolean result; //好瓜与否

    //构造函数
    public BayesBean(String color, String root, String sound, String vein, String navel, String touch, Boolean result)
    {
        this.color = color;
        this.root = root;
        this.sound = sound;
        this.vein = vein;
        this.navel = navel;
        this.touch = touch;
        this.result = result;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getRoot()
    {
        return root;
    }

    public void setRoot(String root)
    {
        this.root = root;
    }

    public String getSound()
    {
        return sound;
    }

    public void setSound(String sound)
    {
        this.sound = sound;
    }

    public String getVein()
    {
        return vein;
    }

    public void setVein(String vein) { this.vein = vein; }

    public String getNavel()
    {
        return navel;
    }

    public void setNavel(String navel)
    {
        this.navel = navel;
    }

    public String getTouch()
    {
        return touch;
    }

    public void setTouch(String touch)
    {
        this.touch = touch;
    }

    public Boolean getResult()
    {
        return result;
    }

    public void setResult(Boolean result)
    {
        this.result = result;
    }
}