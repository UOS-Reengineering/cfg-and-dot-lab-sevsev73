package dependenceAnalysis.intraprocedural;


import dependenceAnalysis.util.ClassDiagram;

import java.io.File;
import java.io.IOException;

public class ClassDiagramGenerator {

    public static void main(String[] args) throws IOException {
        String root = "U:/jfreechart/target/classes";
        Boolean ignoreLibs = true;
        Boolean ignoreInnerClasses = false;
        String signaturePrefix = "org.jfree.chart.renderer";
        String output = "classWithNumMethod.dot";

        ClassDiagram cd = new ClassDiagram(root, ignoreLibs, ignoreInnerClasses, signaturePrefix);
        cd.writeDot(new File(output));
    }
}

