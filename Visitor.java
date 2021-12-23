import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Visitor extends calcBaseVisitor<Void>{
    public String results="";
    public int Num=1;
    public boolean isconst=false;
    public boolean isglobal=false;
    public int blabel=0;
    public int clabel=0;
    public int skip=0;
    public int T=0;
    public ArrayList<Integer> blabels=new ArrayList<Integer>();
    public ArrayList<Integer> clabels=new ArrayList<Integer>();
    public ArrayList<ArrayList> alllist=new ArrayList<ArrayList>();
    public ArrayList<ArrayList> allarray=new ArrayList<ArrayList>();
    public ArrayList<Var> global = new ArrayList<Var>();
    public ArrayList<Narray> gloarray = new ArrayList<Narray>();
    static Integer getnumber(String s){
        boolean flag=false;
        if(s.startsWith("-")){
            s=s.substring(1);
            flag = true;
        }
        int res = 0;
        s = s.toLowerCase(Locale.ROOT);
        if (s.charAt(0)=='0'){
            if(s.length()==1){
                return 0;
            }
            if(s.charAt(1)=='x'||s.charAt(1)=='X'){
                int len = s.length();
                s = s.toLowerCase();
                for (int i=2;i<len;i++){
                    if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                        res=16*res+ (int) s.charAt(i)-48;
                    }
                    else if(s.charAt(i)>='a'&&s.charAt(i)<='f'){
                        res=16*res +10+ ((int) s.charAt(i)-'a');
                    }
                    else {
                        if(flag){
                            return -res;
                        }
                        return res;
                    }
                }
                if(flag){
                    return -res;
                }
                return res;
            }
            else {
                int len = s.length();
                for(int i=1;i<len;i++){
                    res=8*res+ (int) s.charAt(i)-48;
                }
                if(flag){
                    return -res;
                }
                return res;
            }
        }
        else if(s.charAt(0)<'0'||s.charAt(0)>'9'){
            return null;
        }
        else {
            res = Integer.valueOf(s);
            if(flag){
                return -res;
            }
            return res;
        }
    }
    public Void arrayinit(Narray narray,String s,int offset){
        int size=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                size++;
            }
            else {
                break;
            }
        }
        if(size>narray.getSlist().size()){
            System.exit(-1);
        }
        ArrayList<Integer> weight = new ArrayList<Integer>();
        for(int i=0;i<narray.getSlist().size()-1;i++){
            Integer wei=1;
            wei*=narray.getSlist().get(i+1);
            weight.add(wei);
        }
        weight.add(1);
        narray.setWeight(weight);
        int k=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                k++;
            }
            else if(s.charAt(i)=='}'){
                k--;
            }
            else if(s.charAt(i)==','){
                if(offset%weight.get(k-1)==0){
                    offset+=weight.get(k-1);
                }
                else {
                    offset=(offset/(weight.get(k-1))+1)*weight.get(k-1);
                }
            }
            else if(s.charAt(i)=='%'){
                results += "%" + Num + " = getelementptr ["+narray.getSize()+" x i32], ["+narray.getSize()+"x i32]* "+narray.getNum()+", i32 0, i32 "+offset+"\n";
                Register reg3 = new Register();
                reg3.setName("%" + Num);
                reg3.setNum(Num);
                reg3.setType("array*");
                Reglist.getInstance().add(reg3);
                Num++;
                String temp = s.substring(i);
                int dot=(temp.indexOf(",")!=-1)?temp.indexOf(",")+i:99999;
                int bra=(temp.indexOf("}")!=-1)?temp.indexOf("}")+i:99999;
                String sub=s.substring(i,Math.min(dot,bra));
                i+=Math.min(dot,bra)-i-1;
                if(Reglist.getInstance().getreg(sub).getType().equals("array*")){
                    results+="%"+Num +" = load i32, i32* "+sub+"\n";
                    Register reg1 = new Register();
                    reg1.setName("%" + Num);
                    reg1.setNum(Num);
                    reg1.setType("i32");
                    Reglist.getInstance().add(reg1);
                    sub = reg1.getName();
                    Num++;
                }
                sub = regtoi32(sub);
                results+="store i32 "+ sub +", i32* "+reg3.getName()+"\n";
            }
            else{
                results += "%" + Num + " = getelementptr ["+narray.getSize()+" x i32], ["+narray.getSize()+"x i32]* "+narray.getNum()+", i32 0, i32 "+offset+"\n";
                Register reg3 = new Register();
                reg3.setName("%" + Num);
                reg3.setNum(Num);
                reg3.setType("array*");
                Reglist.getInstance().add(reg3);
                Num++;
                String temp = s.substring(i);
                int dot=(temp.indexOf(",")!=-1)?temp.indexOf(",")+i:99999;
                int bra=(temp.indexOf("}")!=-1)?temp.indexOf("}")+i:99999;
                String sub=s.substring(i,Math.min(dot,bra));
                i+=Math.min(dot,bra)-i-1;
                results+="store i32 "+ sub +", i32* "+reg3.getName()+"\n";
            }
        }
        return null;
    }
    public Void conarrayinit(Narray narray,String s,int offset){
        int size=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                size++;
            }
            else {
                break;
            }
        }
        if(size>narray.getSlist().size()){
            System.exit(-2);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> weight = new ArrayList<Integer>();
        for(int i=0;i<narray.getSlist().size()-1;i++){
            Integer wei=1;
            wei*=narray.getSlist().get(i+1);
            weight.add(wei);
        }
        weight.add(1);
        narray.setWeight(weight);
        int k=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                k++;
            }
            else if(s.charAt(i)=='}'){
                k--;
            }
            else if(s.charAt(i)==','){
                if(offset%weight.get(k-1)==0){
                    offset+=weight.get(k-1);
                }
                else {
                    offset=(offset/(weight.get(k-1))+1)*weight.get(k-1);
                }
                for(int j=res.size();j<offset;j++){
                    res.add(0);
                }
            }
            else{
                String temp = s.substring(i);
                int dot=(temp.indexOf(",")!=-1)?temp.indexOf(",")+i:99999;
                int bra=(temp.indexOf("}")!=-1)?temp.indexOf("}")+i:99999;
                String sub=s.substring(i,Math.min(dot,bra));
                i+=Math.min(dot,bra)-i-1;
                res.add(getnumber(sub));
            }
        }
        while(res.size()<narray.getSize()){
            res.add(0);
        }
        narray.setList(res);
        return null;
    }
    public String regtoi32(String s){
        if(!s.startsWith("%")){
            return s;
        }
        else if(Reglist.getInstance().getreg(s).getType().equals("i32")){
            return s;
        }
        else if(Reglist.getInstance().getreg(s).getType().equals("array*")){
            results+="%"+Num +" = load i32, i32* "+s+"\n";
            Register reg1 = new Register();
            reg1.setName("%" + Num);
            reg1.setNum(Num);
            reg1.setType("i32");
            Reglist.getInstance().add(reg1);
            s = reg1.getName();
            Num++;
            return s;
        }
        else if(Reglist.getInstance().getreg(s).getType().equals("i1")){
            results+="%"+Num+" = "+"zext i1 "+Reglist.getInstance().getreg(s).getName()+" to i32\n";
            Register reg = new Register();
            s = "%"+Num;
            reg.setName("%"+Num);
            reg.setNum(Num);
            reg.setType("i32");
            Reglist.getInstance().add(reg);
            Num++;
            return s;
        }
        return s;
    }
    public String regtoi1(String s){
        if(!s.startsWith("%")){
            results+="%"+Num+" = icmp ne i32 "+ s + ", 0"+ "\n";
            Register reg = new Register();
            reg.setName("%"+Num);
            reg.setNum(Num);
            reg.setType("i1");
            Reglist.getInstance().add(reg);
            Num++;
            s=reg.getName();
            return s;
        }
        else if(Reglist.getInstance().getreg(s).getType().equals("i32")){
            results+="%"+Num+" = icmp ne i32 "+ s + ", 0"+ "\n";
            Register reg = new Register();
            reg.setName("%"+Num);
            reg.setNum(Num);
            reg.setType("i1");
            Reglist.getInstance().add(reg);
            Num++;
            s=reg.getName();
            return s;
        }
        else if(Reglist.getInstance().getreg(s).getType().equals("array*")){
            s=regtoi32(s);
            results+="%"+Num+" = icmp ne i32 "+ s + ", 0"+ "\n";
            Register reg = new Register();
            reg.setName("%"+Num);
            reg.setNum(Num);
            reg.setType("i1");
            Reglist.getInstance().add(reg);
            Num++;
            s=reg.getName();
            return s;
        }
        else if(Reglist.getInstance().getreg(s).getType().equals("i1")){
            return s;
        }
        return s;
    }
    @Override public Void visitCompUnit(calcParser.CompUnitContext ctx) {
        for(int i=0;i<ctx.decl().size();i++){
            isglobal = true;
            visit(ctx.decl(i));
            isglobal = false;
        }
        for(int i=0;i<ctx.funcDef().size();i++){
            visit(ctx.funcDef(i));
        }
        return null;
    }
    @Override public Void visitFuncDef(calcParser.FuncDefContext ctx) {
        if(ctx.FuncType().getText().equals("int")){
            results+="define dso_local ";
        }
        if(ctx.Idigit().getText().equals("main")){
            results+="i32 @main";
        }
        results+="()";
        results+="{\n";
        visit(ctx.block());
        results+="}";
        return null;
    }
    @Override public Void visitBlock(calcParser.BlockContext ctx) {
        ArrayList<Var> newlist = new ArrayList<Var>();
        ArrayList<Narray> arrlist = new ArrayList<Narray>();
        allarray.add(arrlist);
        alllist.add(newlist);
//        allconstlist.add(conlist);
        for(int i=0;i<ctx.blockItem().size();i++){
            visit(ctx.blockItem(i));
        }
        alllist.remove(newlist);
        allarray.remove(arrlist);
//        allconstlist.remove(conlist);
        return null;
    }
    @Override public Void visitStmt(calcParser.StmtContext ctx) {
        if(ctx.lval()!=null){
            String a=visitLval(ctx.lval());
            if(getnumber(a)!=null){
                System.exit(-3);
            }
            String s=visitExp(ctx.exp());
            VarList list=VarList.getInstance();
            String name = ctx.lval().getText();
            if(name.indexOf("[")!=-1){
                name = name.substring(0,name.indexOf("["));
            }
            if(alllist.size()>0){
                ArrayList<Var> tlist = alllist.get(alllist.size()-1);
                for(int i=0;i<tlist.size();i++){
                    if(tlist.get(i).getName().equals(name)&&tlist.get(i).isInit()&&tlist.get(i).isIsconst()){
                        System.exit(-4);
                    }
                }
            }
            else if(list.getVar(name).isIsconst()&&list.getVar(name).isInit()){
                System.exit(-5);
            }
            else{
                for(int i=0;i<global.size();i++){
                    if(global.get(i).getName().equals(name)&&global.get(i).isIsconst()){
                        System.exit(-6);
                    }
                }
            }
            if(alllist.size()>0){
                for(int i=alllist.size()-1;i>=0;i--){
                    ArrayList<Var> tlist = alllist.get(i);
                    for(int j=0;j<tlist.size();j++){
                        if(tlist.get(j).getName().equals(name)){
                            tlist.get(j).setInit(true);
                            if(tlist.get(j).getType().equals("a")){
                                s=regtoi32(s);
                                results+="store i32 "+s+", i32* "+ a+"\n";
                            }
                            else {
                                s=regtoi32(s);
                                results += "store i32 " + s + ", i32* " + tlist.get(j).getNum() + "\n";
                            }
                            return null;
                        }
                    }
                }
                for(int i=0;i<global.size();i++){
                    if(global.get(i).getName().equals(name)){
                        global.get(i).setInit(true);
                        if(global.get(i).getType().equals("a")){
                            s=regtoi32(s);
                            results+="store i32 "+s+", i32* "+ a+"\n";
                        }
                        else {
                            s=regtoi32(s);
                            results+="store i32 "+s+", i32* "+ global.get(i).getNum()+"\n";
                        }
                        return null;
                    }
                }
            }
            else {
                list.getVar(name).setInit(true);
                s=regtoi32(s);
                results+="store i32 "+s+", i32* "+ a+"\n";
//                results+="store i32 "+s+", i32* "+ list.getVar(ctx.lval().getText()).getNum()+"\n";
            }
        }
        else if(ctx.block()!=null){
            visit(ctx.block());
        }
        else if(ctx.getText().startsWith("if")){
            if(ctx.stmt().size()==2){
                int Tleft=++T;
                int Tright=++T;
                int Tmid=++T;
                String s = visitCond(ctx.cond());
                s=regtoi32(s);
                if(getnumber(s)!=null){
                    results+="%"+Num+" = icmp ne i32 "+ s + ", 0"+ "\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i1");
                    Reglist.getInstance().add(reg);
                    Num++;
                }
                else if(Reglist.getInstance().getreg(s).getType().equals("i32")){
                results+="%"+Num+" = icmp ne "+Reglist.getInstance().getreg(s).getType() +s + ", 0"+ "\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                }
                results+="br i1 %"+(Num-1)+", label %t"+Tleft+", label %t"+Tright+"\n";
                results+="t"+Tleft+":\n";
                visit(ctx.stmt(0));
                if(skip==0){
                    results+="br label %t"+Tmid+"\n";
                }
                if(skip>0){
                    skip--;
                }
                results+="t"+Tright+":\n";
                visit(ctx.stmt(1));
                if(skip==0){
                    results+="br label %t"+Tmid+"\n";
                }
                if(skip>0){
                    skip--;
                }
                results+="t"+Tmid+":\n";
            }
            else if(ctx.stmt().size()==1){
                int Tleft=++T;
                int Tright=++T;
                int Tmid=T;
                String s = visitCond(ctx.cond());
                s=regtoi32(s);
                if(getnumber(s)!=null){
                    results+="%"+Num+" = icmp ne i32 "+ s + ", 0"+ "\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i1");
                    Reglist.getInstance().add(reg);
                    Num++;
                }
                else if(Reglist.getInstance().getreg(s).getType().equals("i32")){
                    results+="%"+Num+" = icmp ne "+Reglist.getInstance().getreg(s).getType() +s + ", 0"+ "\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i1");
                    Reglist.getInstance().add(reg);
                    Num++;
                }
                results+="br i1 %"+(Num-1)+", label %t"+Tleft+", label %t"+Tmid+"\n";
                results+="t"+Tleft+":\n";
                visit(ctx.stmt(0));
                if(skip==0){
                    results+="br label %t"+Tmid+"\n";
                }
                if(skip>0){
                    skip--;
                }
                results+="t"+Tmid+":\n";
            }
        }
        else if(ctx.getText().startsWith("while")){
            int Tleft=++T;
            int Tright=++T;
            int Tmid=++T;
            results+="br label %t"+Tleft+"\n";
            results+="t"+Tleft+":\n";
            String s = visitCond(ctx.cond());
            s=regtoi32(s);
            if(getnumber(s)!=null){
                results+="%"+Num+" = icmp ne i32 "+ s + ", 0"+ "\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
            }
            else if(Reglist.getInstance().getreg(s).getType().equals("i32")){
                results+="%"+Num+" = icmp ne "+Reglist.getInstance().getreg(s).getType()+" " +s + ", 0"+ "\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
            }
            results+="br i1 %"+(Num-1)+", label %t"+Tright+", label %t"+Tmid+"\n";
            results+="t"+Tright+":\n";
            blabel=Tmid;
            clabel=Tleft;
            blabels.add(blabel);
            clabels.add(clabel);
            visit(ctx.stmt(0));
            blabels.remove(blabels.size()-1);
            clabels.remove(clabels.size()-1);
            blabel=0;
            clabel=0;
            results+="br label %t"+Tleft+"\n";
            results+="t"+Tmid+":\n";
        }
        else if(ctx.getText().startsWith("break")){
            results+="br label %t"+blabels.get(blabels.size()-1)+"\n";
            skip++;
        }
        else if(ctx.getText().startsWith("continue")){
            results+="br label %t"+clabels.get(clabels.size()-1)+"\n";
            skip++;
        }
        else if(ctx.getText().startsWith("return")){
            String s=visitExp(ctx.exp());
            results+="ret i32 "+s+"\n";
            Num++;
        }
        else {
            if(ctx.exp()!=null){
                visit(ctx.exp());
            }
        }
        return null;
    }

    @Override
    public String visitExp(calcParser.ExpContext ctx) {
        return visitAddexp(ctx.addexp());
    }

    @Override
    public String visitAddexp(calcParser.AddexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitMulexp(ctx.mulexp());
            case 3:
                if(isglobal){
                    String left=visitAddexp(ctx.addexp());
                    String right=visitMulexp(ctx.mulexp());
                    int a=0;
                    int b=0;
                    for(int i=0;i<global.size();i++){
                        if(global.get(i).getName().equals(left)&&!global.get(i).isIsconst()){
                            System.exit(-7);
                        }
                        if(global.get(i).getName().equals(left)){
                            a=global.get(i).getValue();
                            break;
                        }
                        if(i==global.size()-1){
                            a=getnumber(left);
                        }
                    }
                    for(int i=0;i<global.size();i++){
                        if(global.get(i).getName().equals(right)&&!global.get(i).isIsconst()){
                            System.exit(-8);
                        }
                        if(global.get(i).getName().equals(right)){
                            b=global.get(i).getValue();
                            break;
                        }
                        if(i==global.size()-1){
                            b=getnumber(right);
                        }
                    }
                    if(ctx.Addfunc().getText().equals("+")){
                        return String.valueOf(a+b);
                    }else {
                        return String.valueOf(a-b);
                    }
                }
                String left=visitAddexp(ctx.addexp());
                String right=visitMulexp(ctx.mulexp());
                if(Objects.equals(ctx.Addfunc().getText(), "+")){
                    if(left.startsWith("%")){
                        left=regtoi32(left);
                    }
                    if(right.startsWith("%")){
                        right=regtoi32(right);
                    }
                    if(getnumber(left)!=null&&getnumber(right)!=null){
                        return String.valueOf(getnumber(left)+getnumber(right));
                    }
                    results+="%"+Num+" = add i32 "+left+","+right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(Objects.equals(ctx.Addfunc().getText(), "-")){
                    if(left.startsWith("%")){
                        left=regtoi32(left);
                    }
                    if(right.startsWith("%")){
                        right=regtoi32(right);
                    }
                    if(getnumber(left)!=null&&getnumber(right)!=null){
                        return String.valueOf(getnumber(left)-getnumber(right));
                    }
                    results+="%"+Num+" = sub i32 "+left+","+right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }

                break;
        }
        return null;
    }

    @Override
    public String visitMulexp(calcParser.MulexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitUnaryexp(ctx.unaryexp());
            case 3:
                if(isglobal){
                    String left=visitMulexp(ctx.mulexp());
                    String right=visitUnaryexp(ctx.unaryexp());
                    int a=0;
                    int b=0;
                    for(int i=0;i<global.size();i++){
                        if(global.get(i).getName().equals(left)&&!global.get(i).isIsconst()){
                            System.exit(-9);
                        }
                        if(global.get(i).getName().equals(left)){
                            a=global.get(i).getValue();
                            break;
                        }
                        if(i==global.size()-1){
                            a=getnumber(left);
                        }
                    }
                    for(int i=0;i<global.size();i++){
                        if(global.get(i).getName().equals(right)&&!global.get(i).isIsconst()){
                            System.exit(-10);
                        }
                        if(global.get(i).getName().equals(right)){
                            b=global.get(i).getValue();
                            break;
                        }
                        if(i==global.size()-1){
                            b=getnumber(right);
                        }
                    }
                    if(ctx.Mulfunc().getText().equals("*")){
                        return String.valueOf(a*b);
                    }else if(ctx.Mulfunc().getText().equals("/")){
                        return String.valueOf(a/b);
                    }else {
                        return String.valueOf(a%b);
                    }
                }
                String left=visitMulexp(ctx.mulexp());
                String right=visitUnaryexp(ctx.unaryexp());
                if(ctx.Mulfunc().getText().equals("*")){
                    if(left.startsWith("%")){
                        left=regtoi32(left);
                    }
                    if(right.startsWith("%")){
                        right=regtoi32(right);
                    }
                    if(getnumber(left)!=null&&getnumber(right)!=null){
                        return String.valueOf(getnumber(left)*getnumber(right));
                    }
                    results+="%"+Num+" = mul i32 "+left+","+right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Mulfunc().getText().equals("/")) {
                    if(left.startsWith("%")){
                        left=regtoi32(left);
                    }
                    if(right.startsWith("%")){
                        right=regtoi32(right);
                    }
                    if(getnumber(left)!=null&&getnumber(right)!=null){
                        return String.valueOf(getnumber(left)/getnumber(right));
                    }
                    results+="%" + Num + " = sdiv i32 " + left + "," + right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%" + (Num - 1);
                }
                else if(ctx.Mulfunc().getText().equals("%")) {
                    if(left.startsWith("%")){
                        left=regtoi32(left);
                    }
                    if(right.startsWith("%")){
                        right=regtoi32(right);
                    }
                    if(getnumber(left)!=null&&getnumber(right)!=null){
                        return String.valueOf(getnumber(left)%getnumber(right));
                    }
                    results+="%" + Num + " = srem i32 " + left + "," + right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%" + (Num - 1);
                }
                break;
        }
        return null;
    }

    @Override
    public String visitUnaryexp(calcParser.UnaryexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitPrimaryexp(ctx.primaryexp());
            case 2:
                String right=visitUnaryexp(ctx.unaryexp());
                if(ctx.Addfunc().getText().equals("+")){
                    if(Reglist.getInstance().getreg("%"+(Num-1)).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = add i32 0, "+right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Addfunc().getText().equals("-")){
                    if(getnumber(right)!=null){
                        return "-"+right;
                    }
                    if(Reglist.getInstance().getreg("%"+(Num-1)).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = sub i32 0, "+right+"\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Addfunc().getText().equals("!")){
                    results+="%"+Num+" = icmp eq "+Reglist.getInstance().getreg("%"+(Num-1)).getType() +" %" + (Num-1) + ", 0"+ "\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i1");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
            default:
                String s = ctx.Idigit().getText();
                if(s.equals("getint")){
                    results+="%"+Num+" = call i32 @getint()\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(s.equals("putint")){
                    String tt=visitFuncrParams(ctx.funcrParams());
                    tt=regtoi32(tt);
                    results+="call void @putint(i32 "+tt+")\n";
                    return null;
                }
                else if(s.equals("getch")){
                    results+="%"+Num+" = call i32 @getch()\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(s.equals("putch")){
                    String tt=visitFuncrParams(ctx.funcrParams());
                    tt=regtoi32(tt);
                    results+="call void @putch(i32 "+tt+")\n";
                    return null;
                }
        }
        return null;
    }

    @Override
    public String visitPrimaryexp(calcParser.PrimaryexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                if(ctx.Number()!=null){
                    String s = ctx.Number().getText();
                    int temp=getnumber(s);
                    return String.valueOf(temp);
                }
                else {
                    String a=visitLval(ctx.lval());
                    return a;
                }
            case 3:
                return visitExp(ctx.exp());
        }
        return null;
    }

    @Override
    public Void visitDecl(calcParser.DeclContext ctx) {
        if(ctx.constDecl()!=null){
            isconst=true;
            visit(ctx.constDecl());
            isconst=false;
        }
        else {
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    public Void visitConstDecl(calcParser.ConstDeclContext ctx) {
        for(int i=0;i<ctx.constDef().size();i++){
            visit(ctx.constDef(i));
        }
        return null;
    }

    @Override
    public Void visitConstDef(calcParser.ConstDefContext ctx) {
        if (ctx.constExp().size() == 0) {
            if (isglobal) {
                String ident = ctx.Idigit().getText();
                for (int i = 0; i < global.size(); i++) {
                    if (global.get(i).getName().equals(ident)) {
                        System.exit(-11);
                    }
                }
                Var var = new Var();
                var.setName(ident);
                var.setType("i");
                var.setNum("@" + ident);
                var.setIsconst(true);
                global.add(var);
                String temp = visitConstInitVal(ctx.constInitVal());
                var.setValue(getnumber(temp));
                var.setInit(true);
                return null;
            }
            //results+="%"+Num+" = alloca i32\n";
            String ident = ctx.Idigit().getText();
            if (alllist.size() > 0) {
                ArrayList<Var> tlist = alllist.get(alllist.size() - 1);
                for (int i = 0; i < tlist.size(); i++) {
                    if (tlist.get(i).getName().equals(ident)) {
                        System.exit(-12);
                    }
                }
            } else if (VarList.getInstance().getVar(ident) != null) {
                System.exit(-13);
            }
            Var var = new Var();
            var.setName(ident);
            var.setType("i");
            var.setNum("@" + ident);
            //var.setNum("%"+Num);
            var.setInit(true);
            var.setIsconst(true);
            var.setValue(0);
            VarList list = VarList.getInstance();
            if (alllist.size() > 0) {
                alllist.get(alllist.size() - 1).add(var);
            } else {
                list.add(var);
            }
            String temp = visitConstInitVal(ctx.constInitVal());
            var.setValue(getnumber(temp));
            return null;
        }
        else {
            if (isglobal) {
                String ident = ctx.Idigit().getText();
                for (int i = 0; i < global.size(); i++) {
                    if (global.get(i).getName().equals(ident)) {
                        System.exit(-14);
                    }
                }
                Var var = new Var();
                var.setName(ident);
                var.setType("a");
                var.setNum("@" + ident);
                var.setIsconst(true);
                var.setInit(true);
                var.setValue(0);
                global.add(var);
                int size=1;
                for(int i=0;i<ctx.constExp().size();i++){
                    size*=getnumber(visitConstExp(ctx.constExp(i)));
                }
                Narray narray = new Narray();
                narray.setName(ident);
                narray.setNum("@" + ident);
                narray.setSize(size);
                narray.setIsconst(true);
                ArrayList<Integer> nlist = new ArrayList<Integer>();
                for(int i=0;i<size;i++){
                    nlist.add(0);
                }
                narray.setList(nlist);
                ArrayList<Integer> slist = new ArrayList<Integer>();
                for(int i=0;i<ctx.constExp().size();i++){
                    slist.add(getnumber(visitConstExp(ctx.constExp(i))));
                }
                narray.setSlist(slist);
                String fs = visitConstInitVal(ctx.constInitVal());
                conarrayinit(narray,fs,0);
                gloarray.add(narray);
                results+=narray.getNum()+" = dso_local constant ["+narray.getSize()+" x i32] [";
                for(int i=0;i<narray.getList().size();i++){
                    if(i!=0){
                        results+=",";
                    }
                    results+="i32 "+ narray.getList().get(i);
                }
                results+="]\n";
                return null;
            }
            String ident = ctx.Idigit().getText();
            if (alllist.size() > 0) {
                ArrayList<Var> tlist = alllist.get(alllist.size() - 1);
                for (int i = 0; i < tlist.size(); i++) {
                    if (tlist.get(i).getName().equals(ident)) {
                        System.exit(-15);
                    }
                }
            } else if (VarList.getInstance().getVar(ident) != null) {
                System.exit(-16);
            }
            Var var = new Var();
            var.setName(ident);
            var.setType("a");
            var.setNum("@" + ident);
            var.setInit(true);
            var.setIsconst(true);
            var.setValue(0);
            VarList list = VarList.getInstance();
            if (alllist.size() > 0) {
                alllist.get(alllist.size() - 1).add(var);
            } else {
                list.add(var);
            }
            int size=1;
            for(int i=0;i<ctx.constExp().size();i++){
                size*=getnumber(visitConstExp(ctx.constExp(i)));
            }
            Narray narray = new Narray();
            narray.setName(ident);
            narray.setNum("@" + ident);
            narray.setSize(size);
            narray.setIsconst(true);
            ArrayList<Integer> nlist = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                nlist.add(0);
            }
            narray.setList(nlist);
            ArrayList<Integer> slist = new ArrayList<Integer>();
            for(int i=0;i<ctx.constExp().size();i++){
                slist.add(getnumber(visitConstExp(ctx.constExp(i))));
            }
            narray.setSlist(slist);
            String fs = visitConstInitVal(ctx.constInitVal());
            conarrayinit(narray,fs,0);
            allarray.get(alllist.size()-1).add(narray);
            return null;
        }
    }

    @Override
    public String visitConstInitVal(calcParser.ConstInitValContext ctx) {
        if(ctx.constExp()!=null){
            return visitConstExp(ctx.constExp());
        }
        else {
            String res = "{";
            for (int i = 0; i < ctx.constInitVal().size(); i++) {
                res += visitConstInitVal(ctx.constInitVal(i));
                if (i < ctx.constInitVal().size() - 1) {
                    res += ",";
                }
            }
            res += "}";
            return res;
        }
    }

    @Override
    public String visitConstExp(calcParser.ConstExpContext ctx) {
        return visitAddexp(ctx.addexp());
    }

    @Override
    public Void visitVarDecl(calcParser.VarDeclContext ctx) {
        for(int i=0;i<ctx.varDef().size();i++){
            visit(ctx.varDef(i));
        }
        return null;
    }

    @Override
    public Void visitVarDef(calcParser.VarDefContext ctx) {
        if(ctx.constExp().size()==0) {
            switch (ctx.children.size()) {
                case 1:
                    if (isglobal) {
                        String ident1 = ctx.Idigit().getText();
                        for (int i = 0; i < global.size(); i++) {
                            if (global.get(i).getName().equals(ident1)) {
                                System.exit(-17);
                            }
                        }
                        Var var1 = new Var();
                        var1.setName(ident1);
                        var1.setType("i");
                        var1.setIsconst(false);
                        var1.setNum("@" + ident1);
                        var1.setValue(0);
                        global.add(var1);
                        var1.setInit(true);
                        results += "@" + ident1 + " = dso_local global i32 " + var1.getValue() + "\n";
                        return null;
                    }
                    results += "%" + Num + " = alloca i32\n";
                    String ident = ctx.Idigit().getText();
                    if (alllist.size() > 0) {
                        ArrayList<Var> tlist = alllist.get(alllist.size() - 1);
                        for (int i = 0; i < tlist.size(); i++) {
                            if (tlist.get(i).getName().equals(ident)) {
                                System.exit(-18);
                            }
                        }
                    } else if (VarList.getInstance().getVar(ident) != null) {
                        System.exit(-19);
                    }
                    Var var = new Var();
                    var.setName(ident);
                    var.setType("i");
                    var.setNum("%" + Num);
                    var.setIsconst(false);
                    var.setInit(false);
                    VarList list = VarList.getInstance();
                    if (alllist.size() > 0) {
                        alllist.get(alllist.size() - 1).add(var);
                    } else {
                        list.add(var);
                    }
                    Register reg = new Register();
                    reg.setName("%" + Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    break;
                case 3:
                    if (isglobal) {
                        String ident1 = ctx.Idigit().getText();
                        for (int i = 0; i < global.size(); i++) {
                            if (global.get(i).getName().equals(ident1)) {
                                System.exit(-20);
                            }
                        }
                        Var var1 = new Var();
                        var1.setName(ident1);
                        var1.setType("i");
                        var1.setIsconst(false);
                        var1.setNum("@" + ident1);
                        var1.setValue(0);
                        global.add(var1);
                        String temp = visitInitVal(ctx.initVal());
                        var1.setValue(getnumber(temp));
                        var1.setInit(true);
                        results += "@" + ident1 + " = dso_local global i32 " + getnumber(temp) + "\n";
                        return null;
                    }
                    results += "%" + Num + " = alloca i32\n";
                    ident = ctx.Idigit().getText();
                    if (alllist.size() > 0) {
                        ArrayList<Var> tlist = alllist.get(alllist.size() - 1);
                        for (int i = 0; i < tlist.size(); i++) {
                            if (tlist.get(i).getName().equals(ident)) {
                                System.exit(-21);
                            }
                        }
                    } else if (VarList.getInstance().getVar(ident) != null) {
                        System.exit(-22);
                    }
                    var = new Var();
                    var.setName(ident);
                    var.setType("i");
                    var.setNum("%" + Num);
                    var.setInit(true);
                    var.setIsconst(false);
                    list = VarList.getInstance();
                    if (alllist.size() > 0) {
                        alllist.get(alllist.size() - 1).add(var);
                    } else {
                        list.add(var);
                    }
                    Register reg2 = new Register();
                    reg2.setName("%" + Num);
                    reg2.setNum(Num);
                    reg2.setType("i32");
                    Reglist.getInstance().add(reg2);
                    Num++;
                    String temp = visitInitVal(ctx.initVal());
                    String loc = var.getNum();
                    temp=regtoi32(temp);
                    results += "store i32 " + temp + ", i32* " + loc + "\n";
                    break;
            }
            return null;
        }
        else {
            if(ctx.initVal()==null){
                if (isglobal) {
                    String ident = ctx.Idigit().getText();
                    for (int i = 0; i < global.size(); i++) {
                        if (global.get(i).getName().equals(ident)) {
                            System.exit(-23);
                        }
                    }
                    Var var = new Var();
                    var.setName(ident);
                    var.setType("a");
                    var.setNum("@" + ident);
                    var.setIsconst(false);
                    var.setInit(true);
                    var.setValue(0);
                    global.add(var);
                    int size=1;
                    for(int i=0;i<ctx.constExp().size();i++){
                        size*=getnumber(visitConstExp(ctx.constExp(i)));
                    }
                    Narray narray = new Narray();
                    narray.setName(ident);
                    narray.setNum("@" + ident);
                    narray.setSize(size);
                    narray.setIsconst(false);
                    ArrayList<Integer> nlist = new ArrayList<Integer>();
                    for(int i=0;i<size;i++){
                        nlist.add(0);
                    }
                    narray.setList(nlist);
                    ArrayList<Integer> slist = new ArrayList<Integer>();
                    for(int i=0;i<ctx.constExp().size();i++){
                        slist.add(getnumber(visitConstExp(ctx.constExp(i))));
                    }
                    narray.setSlist(slist);
                    ArrayList<Integer> weight = new ArrayList<Integer>();
                    for(int i=0;i<narray.getSlist().size()-1;i++){
                        Integer wei=1;
                        wei*=narray.getSlist().get(i+1);
                        weight.add(wei);
                    }
                    weight.add(1);
                    narray.setWeight(weight);
                    results+=narray.getNum()+" = dso_local global ["+narray.getSize()+" x i32] zeroinitializer\n";
                    gloarray.add(narray);
                    return null;
                }
                int size=1;
                for(int i=0;i<ctx.constExp().size();i++){
                    size*=getnumber(visitConstExp(ctx.constExp(i)));
                }
                results += "%" + Num + " = alloca ["+size+"x i32]\n";
                String ident = ctx.Idigit().getText();
                if (alllist.size() > 0) {
                    ArrayList<Var> tlist = alllist.get(alllist.size() - 1);
                    for (int i = 0; i < tlist.size(); i++) {
                        if (tlist.get(i).getName().equals(ident)) {
                            System.exit(-24);
                        }
                    }
                } else if (VarList.getInstance().getVar(ident) != null) {
                    System.exit(-25);
                }
                Var var = new Var();
                var.setName(ident);
                var.setType("a");
                var.setNum("%" + Num);
                var.setInit(true);
                var.setIsconst(false);
                VarList list = VarList.getInstance();
                Narray narray = new Narray();
                narray.setName(ident);
                narray.setNum("%" + Num);
                narray.setSize(size);
                narray.setIsconst(false);
                ArrayList<Integer> nlist = new ArrayList<Integer>();
                for(int i=0;i<size;i++){
                    nlist.add(0);
                }
                narray.setList(nlist);
                ArrayList<Integer> slist = new ArrayList<Integer>();
                for(int i=0;i<ctx.constExp().size();i++){
                    slist.add(getnumber(visitConstExp(ctx.constExp(i))));
                }
                narray.setSlist(slist);
                ArrayList<Integer> weight = new ArrayList<Integer>();
                for(int i=0;i<narray.getSlist().size()-1;i++){
                    Integer wei=1;
                    wei*=narray.getSlist().get(i+1);
                    weight.add(wei);
                }
                weight.add(1);
                narray.setWeight(weight);
                if (alllist.size() > 0) {
                    alllist.get(alllist.size() - 1).add(var);
                } else {
                    list.add(var);
                }
                Register reg2 = new Register();
                reg2.setName("%" + Num);
                reg2.setNum(Num);
                reg2.setType("array");
                Reglist.getInstance().add(reg2);
                Num++;
                results += "%" + Num + " = getelementptr ["+size+" x i32], ["+size+"x i32]* "+narray.getNum()+", i32 0, i32 0\n";
                Register reg3 = new Register();
                reg3.setName("%" + Num);
                reg3.setNum(Num);
                reg3.setType("array*");
                Reglist.getInstance().add(reg3);
                results+="call void @memset(i32* %"+ Num +", i32 0, i32 "+size*4+")\n";
                Num++;
                allarray.get(alllist.size()-1).add(narray);
            }
            else {
                if (isglobal) {
                    String ident = ctx.Idigit().getText();
                    for (int i = 0; i < global.size(); i++) {
                        if (global.get(i).getName().equals(ident)) {
                            System.exit(-26);
                        }
                    }
                    Var var = new Var();
                    var.setName(ident);
                    var.setType("a");
                    var.setNum("@" + ident);
                    var.setIsconst(false);
                    var.setInit(true);
                    var.setValue(0);
                    global.add(var);
                    int size=1;
                    for(int i=0;i<ctx.constExp().size();i++){
                        size*=getnumber(visitConstExp(ctx.constExp(i)));
                    }
                    Narray narray = new Narray();
                    narray.setName(ident);
                    narray.setNum("@" + ident);
                    narray.setSize(size);
                    narray.setIsconst(false);
                    ArrayList<Integer> nlist = new ArrayList<Integer>();
                    for(int i=0;i<size;i++){
                        nlist.add(0);
                    }
                    narray.setList(nlist);
                    ArrayList<Integer> slist = new ArrayList<Integer>();
                    for(int i=0;i<ctx.constExp().size();i++){
                        slist.add(getnumber(visitConstExp(ctx.constExp(i))));
                    }
                    narray.setSlist(slist);
                    String fs = visitInitVal(ctx.initVal());
                    conarrayinit(narray,fs,0);
                    gloarray.add(narray);
                    results+=narray.getNum()+" = dso_local global ["+narray.getSize()+" x i32] [";
                    for(int i=0;i<narray.getList().size();i++){
                        if(i!=0){
                            results+=",";
                        }
                        results+="i32 "+ narray.getList().get(i);
                    }
                    results+="]\n";
                    return null;
                }
                int size=1;
                for(int i=0;i<ctx.constExp().size();i++){
                    size*=getnumber(visitConstExp(ctx.constExp(i)));
                }
                results += "%" + Num + " = alloca ["+size+"x i32]\n";
                String ident = ctx.Idigit().getText();
                if (alllist.size() > 0) {
                    ArrayList<Var> tlist = alllist.get(alllist.size() - 1);
                    for (int i = 0; i < tlist.size(); i++) {
                        if (tlist.get(i).getName().equals(ident)) {
                            System.exit(-27);
                        }
                    }
                } else if (VarList.getInstance().getVar(ident) != null) {
                    System.exit(-28);
                }
                Var var = new Var();
                var.setName(ident);
                var.setType("a");
                var.setNum("%" + Num);
                var.setInit(true);
                var.setIsconst(false);
                VarList list = VarList.getInstance();
                Narray narray = new Narray();
                narray.setName(ident);
                narray.setNum("%" + Num);
                narray.setSize(size);
                narray.setIsconst(false);
                ArrayList<Integer> nlist = new ArrayList<Integer>();
                for(int i=0;i<size;i++){
                    nlist.add(0);
                }
                narray.setList(nlist);
                ArrayList<Integer> slist = new ArrayList<Integer>();
                for(int i=0;i<ctx.constExp().size();i++){
                    slist.add(getnumber(visitConstExp(ctx.constExp(i))));
                }
                narray.setSlist(slist);
                if (alllist.size() > 0) {
                    alllist.get(alllist.size() - 1).add(var);
                } else {
                    list.add(var);
                }
                Register reg2 = new Register();
                reg2.setName("%" + Num);
                reg2.setNum(Num);
                reg2.setType("array");
                Reglist.getInstance().add(reg2);
                Num++;
                results += "%" + Num + " = getelementptr ["+size+" x i32], ["+size+"x i32]* "+narray.getNum()+", i32 0, i32 0\n";
                Register reg3 = new Register();
                reg3.setName("%" + Num);
                reg3.setNum(Num);
                reg3.setType("array*");
                Reglist.getInstance().add(reg3);
                results+="call void @memset(i32* %"+ Num +", i32 0, i32 "+size*4+")\n";
                Num++;
                String fs = visitInitVal(ctx.initVal());
                if(narray.getName().equals("c")){
                    System.out.println(2);
                }
                arrayinit(narray,fs,0);
                allarray.get(alllist.size()-1).add(narray);
            }
            return null;
        }
    }

    @Override
    public String visitInitVal(calcParser.InitValContext ctx) {
        if(ctx.exp()!=null){
            return visitExp(ctx.exp());
        }
        else {
            String res="{";
            for(int i=0;i<ctx.initVal().size();i++){
                res+=visitInitVal(ctx.initVal(i));
                if(i<ctx.initVal().size()-1){
                    res+=",";
                }
            }
            res+="}";
            return res;
        }
    }

    @Override
    public Void visitBlockItem(calcParser.BlockItemContext ctx) {
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public String visitLval(calcParser.LvalContext ctx) {
        if(ctx.exp().size()==0) {
            Var var = VarList.getInstance().getVar(ctx.getText());
            for (int i = alllist.size() - 1; i >= 0; i--) {
                ArrayList<Var> tlist = alllist.get(i);
                boolean bk = false;
                for (int j = 0; j < tlist.size(); j++) {
                    if (tlist.get(j).getName().equals(ctx.getText())) {
                        var = tlist.get(j);
                        bk = true;
                        break;
                    }
                }
                if (bk) {
                    break;
                }
            }
            if (var == null) {
                for (int i = 0; i < global.size(); i++) {
                    if (global.get(i).getName().equals(ctx.getText())) {
                        var = global.get(i);
                        if (isglobal && !global.get(i).isIsconst()) {
                            System.exit(-29);
                        }
                        if (global.get(i).isIsconst()) {
                            return String.valueOf(var.getValue());
                        }
                        results += "%" + Num + " = load i32, i32* " + var.getNum() + "\n";
                        Register reg = new Register();
                        reg.setName("%" + Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                        return reg.getName();
                    }
                }
            }
            if(var.getType().equals("a")){
                System.exit(-30);
            }
            if (!var.isIsconst() && isconst) {
                System.exit(-31);
            }
            if (var.isIsconst()) {
                return String.valueOf(var.getValue());
            }
            if (var.isInit()) {
                results += "%" + Num + " = load i32, i32* " + var.getNum() + "\n";
                Register reg = new Register();
                reg.setName("%" + Num);
                reg.setNum(Num);
                reg.setType("i32");
                Reglist.getInstance().add(reg);
                Num++;
            }
            return "%" + (Num - 1);
        }
        else {
            String name=ctx.getText().substring(0,ctx.getText().indexOf("["));
            Var var = VarList.getInstance().getVar(name);
            for (int i = alllist.size() - 1; i >= 0; i--) {
                ArrayList<Var> tlist = alllist.get(i);
                boolean bk = false;
                for (int j = 0; j < tlist.size(); j++) {
                    if (tlist.get(j).getName().equals(name)) {
                        var = tlist.get(j);
                        bk = true;
                        break;
                    }
                }
                if (bk) {
                    break;
                }
            }
            if (var == null) {
                String ss = ctx.getText().substring(0,ctx.getText().indexOf("["));
                Narray nar = new Narray();
                for(int i=0;i<gloarray.size();i++){
                    if(gloarray.get(i).getName().equals(ss)){
                        nar = gloarray.get(i);
                        break;
                    }
                }
                Register lastreg=null;
                for(int i=0;i<ctx.exp().size();i++){
                    String s=visitExp(ctx.exp(i));
                    s = regtoi32(s);
                    results+="%" + Num +" = mul i32 "+ s+", "+nar.getWeight().get(i)+"\n";
                    Register reg = new Register();
                    reg.setName("%" + Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    if(lastreg==null){
                        lastreg = reg;
                    }
                    Num++;
                    if(i!=0){
                        results+="%" + Num +" = add i32 %"+ (Num-1)+", %"+lastreg.getNum()+"\n";
                        Register reg2 = new Register();
                        reg2.setName("%" + Num);
                        reg2.setNum(Num);
                        reg2.setType("i32");
                        Reglist.getInstance().add(reg2);
                        lastreg = reg2;
                        Num++;
                    }
                }
                results += "%" + Num + " = getelementptr ["+nar.getSize()+" x i32], ["+nar.getSize()+"x i32]* "+nar.getNum()+", i32 0, i32 %"+(Num-1)+"\n";
                Register reg = new Register();
                reg.setName("%" + Num);
                reg.setNum(Num);
                reg.setType("array*");
                Reglist.getInstance().add(reg);
                Num++;
            }
            else {
                Narray nar = new Narray();
                for(int i=allarray.size()-1;i>=0;i--){
                    ArrayList<Narray> tlist = allarray.get(i);
                    boolean bk = false;
                    for(int j=0;j<tlist.size();j++){
                        if(tlist.get(j).getName().equals(name)){
                            nar = tlist.get(j);
                            bk=true;
                            break;
                        }
                    }
                    if (bk) {
                        break;
                    }
                }
                for(int i=0;i<ctx.exp().size();i++){
                    String s=visitExp(ctx.exp(i));
                    s = regtoi32(s);
                    results+="%" + Num +" = mul i32 "+ s+", "+nar.getWeight().get(i)+"\n";
                    Register reg = new Register();
                    reg.setName("%" + Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    if(i!=0){
                        results+="%" + Num +" = add i32 %"+ (Num-1)+", %"+(Num-2)+"\n";
                        Register reg2 = new Register();
                        reg2.setName("%" + Num);
                        reg2.setNum(Num);
                        reg2.setType("i32");
                        Reglist.getInstance().add(reg2);
                        Num++;
                    }
                }
                results += "%" + Num + " = getelementptr ["+nar.getSize()+" x i32], ["+nar.getSize()+"x i32]* "+nar.getNum()+", i32 0, i32 %"+(Num-1)+"\n";
                Register reg = new Register();
                reg.setName("%" + Num);
                reg.setNum(Num);
                reg.setType("array*");
                Reglist.getInstance().add(reg);
                Num++;
            }
            return "%" + (Num - 1);
        }
    }

    @Override
    public String visitFuncrParams(calcParser.FuncrParamsContext ctx) {
        String s = "";
        for(int i=0;i<ctx.exp().size();i++){
            s+=visitExp(ctx.exp(i));
        }
        return s;
    }

    @Override
    public String visitCond(calcParser.CondContext ctx) {
        String s=visitLorexp(ctx.lorexp());
        return s;
    }

    @Override
    public String visitLorexp(calcParser.LorexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s =visitLandexp(ctx.landexp());
                return s;
            case 3:
                String s1 = visitLorexp(ctx.lorexp());
                String s2 = visitLandexp(ctx.landexp());
                s1=regtoi1(s1);
                s2=regtoi1(s2);
                results+="%"+Num+" = or i1 "+s1+","+s2+"\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }

    @Override
    public String visitLandexp(calcParser.LandexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s = visitEqexp(ctx.eqexp());
                return s;
            case 3:
                String s1 =visitLandexp(ctx.landexp());
                String s2 =visitEqexp(ctx.eqexp());
                s1=regtoi1(s1);
                s2=regtoi1(s2);
                results+="%"+Num+" = and i1 "+s1+","+s2+"\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }

    @Override
    public String visitEqexp(calcParser.EqexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s = visitRelexp(ctx.relexp());
                return s;
            case 3:
                String t1 = visitEqexp(ctx.eqexp());
                String t2 = visitRelexp(ctx.relexp());
                t1=regtoi32(t1);
                t2=regtoi32(t2);
                if(ctx.Judgefunc().getText().equals("==")){
                    results+="%"+Num+" = icmp eq i32 " + t1 + ", "+ t2 + "\n";
                }
                else {
                    results+="%"+Num+" = icmp ne i32 " + t1 + ", "+ t2 + "\n";
                }
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }

    @Override
    public String visitRelexp(calcParser.RelexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s = visitAddexp(ctx.addexp());
                return s;
            case 3:
                String s1 = visitRelexp(ctx.relexp());
                String s2 = visitAddexp(ctx.addexp());
                s1=regtoi32(s1);
                s2=regtoi32(s2);
                if(ctx.Comfunc().getText().equals("<=")){
                    results+="%"+Num+" = icmp sle i32 " + s1 + ", "+ s2 + "\n";
                }
                else if(ctx.Comfunc().getText().equals(">=")){
                    results+="%"+Num+" = icmp sge i32 " + s1 + ", "+ s2 + "\n";
                }
                else if(ctx.Comfunc().getText().equals("<")){
                    results+="%"+Num+" = icmp slt i32 " + s1 + ", "+ s2 + "\n";
                }
                else if(ctx.Comfunc().getText().equals(">")){
                    results+="%"+Num+" = icmp sgt i32 " + s1 + ", "+ s2 + "\n";
                }
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }
}