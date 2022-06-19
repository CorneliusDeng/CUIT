package Kmeans;

import java.io.Serializable;

public class KmeansBean
{
    private double R;//最近一次消费时间间隔
    private double F;//消费频率
    private double M;//消费总金额

    public KmeansBean(double R, double F, double M)
    {
        this.R = R;
        this.F = F;
        this.M = M;
    }

    public KmeansBean() {

    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public double getF() {
        return F;
    }

    public void setF(double f) {
        F = f;
    }

    public double getM() {
        return M;
    }

    public void setM(double m) {
        M = m;
    }

    @Override
    public String toString()
    {
        return "最近一次消费时间间隔R=" + R + "，消费频率F=" + F + "，消费总金额M=" + M;
    }
}
