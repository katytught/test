import java.util.ArrayList;

public class Narray {
    private String name;//变量名
    private String num;//寄存器编号
    private boolean isconst;//是否为const
    private ArrayList<Integer> list;//存储值列表
    private ArrayList<Integer> slist;//维度列表
    private int size;
    private ArrayList<Integer> weight;

    public ArrayList<Integer> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<Integer> weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Integer> getSlist() {
        return slist;
    }

    public void setSlist(ArrayList<Integer> slist) {
        this.slist = slist;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public boolean isIsconst() {
        return isconst;
    }

    public void setIsconst(boolean isconst) {
        this.isconst = isconst;
    }
}
