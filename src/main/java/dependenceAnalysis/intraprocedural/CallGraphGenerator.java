package dependenceAnalysis.intraprocedural;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import dependenceAnalysis.interprocedural.CallGraph;
import dependenceAnalysis.interprocedural.ClassCallGraph;
import dependenceAnalysis.interprocedural.RestrictedCallGraph;
import dependenceAnalysis.util.Signature;
import org.objectweb.asm.tree.ClassNode;

public class CallGraphGenerator {

    public static void main(String[] args) throws IOException{
        CallGraph cg = null;
        if(args.length>1){
            cg = new RestrictedCallGraph(args[0],args[1]);
            System.out.println(cg);
        }else {
            cg = new CallGraph( "U:/jfreechart/target/classes");
        }
        //Signature mostUsedMethod = findMostUsedMethod(cg);
        //System.out.println(cg);
        //System.out.println("The most called method is: "+mostUsedMethod);
        ClassCallGraph ccg = new ClassCallGraph("U:/jfreechart/target/classes");
        //this gets me the classes
        System.out.println(ccg.getClassCG().getNodes().toString());
    }

    private static Signature findMostUsedMethod(CallGraph cg) throws IOException {
        int max = 0;
        Signature maxSignature = null;
        String toReturn = "Method, Number of uses\n";
        for(Signature sig : cg.getCallGraph().getNodes()){
            int incoming = cg.getCallGraph().getPredecessors(sig).size();
            if (incoming > 4) {
                               toReturn += sig+", "
                        + incoming+"\n";
            }
            BufferedWriter fw = new BufferedWriter(new FileWriter("most_used_methods.csv"));
            fw.write(toReturn);
            fw.flush();
            fw.close();
            if(incoming>max){
                max = incoming;
                maxSignature = sig;
                //System.out.println("The most called method so far is: " + maxSignature + "with:" + max);
            }
        }
        return maxSignature;
    }

    private static void generateFanInFanOut(ClassCallGraph ccg) throws IOException {
        String toReturnIn = "Class, Fan-In\n";
        String toReturnOut = "Class, Fan-out\n";
    }




}
