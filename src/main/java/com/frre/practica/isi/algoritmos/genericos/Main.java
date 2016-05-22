package com.frre.practica.isi.algoritmos.genericos;

import com.frre.library.Utils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.StringBuilderWriter;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by justo on 04/05/16.
 */
public class Main {

    public static final String AMBIENTE = "Ambiente";
    public static final String ALGORITMO = "Algoritmo";
    public static final String END_LINE = ";";
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";
    public static final String FIN_ALGORITMO = "Fin_Algoritmo";
    public static final String ESCRIBIR = "Escribir(";
    public static final String LEER = "Leer(";
    public static final String SI = "Si(";
    public static final String ENTONCES = ")entonces";
    public static final String FIN = "Fin";
    public static final String SINO = "sino";
    private static final String SINO_SI = "sino si";
    public static final String MIENTRAS = "Mientras(";
    public static final String HACER = ")hacer";
    public static final String REPETIR = "Repetir";
    public static final String HASTA = "Hasta(";
    public static final String PARA = "Para(";


    public static HashMap<String, String> theVariables = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        StringWriter writer = null;
        try {
            inputStream = new FileInputStream("algoritmos/Prueba3.algoritmo");
            writer = new StringWriter();
            PrintWriter out = new PrintWriter(writer);

            String everything = IOUtils.toString(inputStream);

            //public class
            addHeader(writer);

            //
            tryToExtractVariables(everything, writer);

            //main
            tryToExtractAction(everything, writer);

            //final {
            addFooter(writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }

        compilationAndExec(writer);

    }

    private static void compilationAndExec(StringWriter writer) throws MalformedURLException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        JavaFileObject file = new JavaSourceFromString("Prueba", writer.toString());

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);

        boolean success = task.call();

        System.out.println(writer.toString());
        System.out.println("Estado Compilacion: " + (success?"Correcto":"Incorrecto revisar algoritmo"));

        if (success) {
            try {

                URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File("").toURI().toURL()});
                Class.forName("Prueba", true, classLoader).getDeclaredMethod("main", new Class[]{String[].class}).invoke(null, new Object[]{null});

            } catch (ClassNotFoundException e) {
                System.err.println("Class not found: " + e);
            } catch (NoSuchMethodException e) {
                System.err.println("No such method: " + e);
            } catch (IllegalAccessException e) {
                System.err.println("Illegal access: " + e);
            } catch (InvocationTargetException e) {
                System.err.println("Invocation target: " + e);
            }
        }
    }

    private static void tryToExtractVariables(String everything, Writer writer) throws IOException {
        String ambiente = everything.substring(getPositionOf(AMBIENTE, everything) + AMBIENTE.length(), getPositionOf(ALGORITMO, everything));
        ambiente = ambiente.trim();
        String[] variables = ambiente.split(";");

        writer.write(" static Scanner sc = new Scanner(System.in); \n");

        for (int i = 0; i < variables.length; i++) {
            String[] variable = variables[i].split(":");
            String name = variable[0].trim();
            String dataType = Utils.getType(variable[1].trim());

            theVariables.put(name, dataType);

            writer.write(" static " + dataType + SPACE + name + END_LINE + NEW_LINE);
        }
    }

    private static int getPositionOf(String ambiente, String everything) {
        if (everything.indexOf(ambiente) != -1) {
            return everything.indexOf(ambiente);
        } else {
            return everything.indexOf(ambiente.toLowerCase());
        }
    }

    private static void addFooter(Writer writer) throws IOException {
        writer.write("}");
    }

    private static void addHeader(Writer writer) throws IOException {
        writer.write("import java.util.*; \n");
        writer.write("public class Prueba { \n \n");
        writer.write("//ambiente \n \n");
    }

    private static void tryToExtractAction(String everything, Writer writer) throws IOException {
        String algoritmo = everything.substring(getPositionOf(ALGORITMO, everything) + ALGORITMO.length(), getPositionOf(FIN_ALGORITMO, everything));
        String[] actions = algoritmo.replaceAll(";", "").split("\n");

        writer.write("//algoritmo \n");
        writer.write("public static void main(String[] args){ \n");

        int i = 0;
        ArrayList<String> pilaAcciones = new ArrayList<String>();
        while (i < actions.length) {
            String line = actions[i].trim();
            line = line.replace(" mod ", " % ");
            if (!detectAction(line, writer)) {
                specialAction(line, writer, pilaAcciones);
            }
            i++;
        }

        writer.write("}\n");


    }

    private static void specialAction(String line, Writer writer, ArrayList<String> pilaAcciones) throws IOException {
        if (line.contains(SI) && line.contains(ENTONCES) && !line.contains(SINO)) {
            String logic = line.substring(getPositionOf(SI, line) + SI.length(), getPositionOf(ENTONCES, line));
            logic = logic.replaceAll(" = ", " == ").replaceAll(" <> ", " != ");
            logic = replaceWithEquals(logic);
            writer.write("if (" + logic + "){\n");
        } else if (line.contains(FIN)) {
            writer.write("}\n");
        }else if (line.contains(REPETIR)) {
            writer.write("do { \n");
        }  else if (line.trim().equalsIgnoreCase(SINO)) {
            writer.write("} else { \n");
        } else if (line.trim().equalsIgnoreCase(SINO_SI)) {
            String logic = line.substring(getPositionOf(SI, line) + SI.length(), getPositionOf(ENTONCES, line));
            logic = logic.replaceAll(" = ", " == ").replaceAll(" <> ", " != ");
            logic = replaceWithEquals(logic);
            writer.write("} else if (" + logic + "){\n");
        } else if (line.contains(HASTA) && line.contains(")")){
            String logic = line.substring(getPositionOf(HASTA, line) + HASTA.length(), getPositionOf(")", line));
            logic = logic.replaceAll(" = ", " == ").replaceAll(" <> ", " != ");
            logic = replaceWithEquals(logic);
            writer.write(" } while (" + logic + ");\n");
        } else if (line.contains(PARA) && line.contains(")hacer")){
            String logic = line.substring(getPositionOf(HASTA, line) + HASTA.length(), getPositionOf(")", line));
            String[] actions = logic.split(",");
            String letter = actions[0].split("hasta")[0].split("=")[0].trim();
            String init = actions[0].split("hasta")[0].split("=")[1].trim();
            String tope = actions[0].split("hasta")[1].trim();
            String aumento = actions[1].substring(actions[1].indexOf(letter)+letter.length()).trim();
            if (aumento.contains("=")){
                aumento = aumento.replace(":=","=");
            }
            writer.write("for("+letter+"="+init+";"+letter+" < "+tope+";"+letter+aumento+") { \n");
        }
    }

    private static String replaceWithEquals(String logic) {
        StringBuilder builder = new StringBuilder();
        if (logic.contains(" and ")) {
            String[] actions = logic.split(" and ");
            for (int i = 0; i < actions.length; i++) {
                String subline = actions[i];
                if (subline.contains(" or ")) {
                    String[] ires = subline.split(" or ");
                    for (int j = 0; j < ires.length; j++) {
                        String[] line = ires[j].split(" == ");
                        if (line.length > 1 && theVariables.get(line[0]) != null && theVariables.get(line[0]).trim().equalsIgnoreCase("String")) {
                            builder.append(line[0].trim() + ".equalsIgnoreCase(" + line[1].trim() + ")");
                        } else {
                            builder.append(ires[j]);
                        }
                        if (j != ires.length-1){
                            builder.append(" || ");
                        }
                    }
                } else {
                    String[] line = subline.split(" == ");
                    if (line.length > 1 && theVariables.get(line[0]) != null && theVariables.get(line[0]).trim().equalsIgnoreCase("String")) {
                        builder.append(line[0].trim() + ".equalsIgnoreCase(" + line[1].trim() + ")");
                    } else {
                        builder.append(subline);
                    }
                }
                if (i != actions.length-1){
                    builder.append(" && ");
                }
            }
        } else if (logic.contains(" or ")) {
            String[] actions = logic.split(" or ");
            for (int i = 0; i < actions.length; i++) {
                String subline = actions[i];
                String[] line = subline.split(" == ");
                if (line.length > 1 && theVariables.get(line[0]) != null &&  theVariables.get(line[0]).trim().equalsIgnoreCase("String")) {
                    logic.replaceAll(subline, line[0].trim() + ".equalsIgnoreCase(" + line[1].trim() + ")");
                } else {
                    builder.append(subline);
                }
                if (i != actions.length-1){
                    builder.append(" || ");
                }
            }
        } else {
            String subline = logic;
            String[] line = subline.split(" == ");
            if (line.length > 1 && theVariables.get(line[0]) != null && theVariables.get(line[0]).trim().equalsIgnoreCase("String")) {
                logic.replaceAll(subline, line[0].trim() + ".equalsIgnoreCase(" + line[1].trim() + ")");
            } else {
                builder.append(subline);
            }
        }

        return builder.toString();
    }

    private static boolean detectAction(String line, Writer writer) throws IOException {
        if (line.contains(ESCRIBIR) || line.contains(ESCRIBIR.toLowerCase())) {
            String titAMostrar = line.substring(getPositionOf(ESCRIBIR, line) + ESCRIBIR.length(), getPositionOf(")", line));
            if (titAMostrar.contains(",\"")) {
                String[] concat = titAMostrar.split(",");
                writer.write("System.out.println(");
                for (int i = 0; i < concat.length; i++) {
                    writer.write(concat[i]);
                    if (i != concat.length - 1) {
                        writer.write("+");
                    }
                }
                writer.write("); \n");
            } else {
                writer.write("System.out.println(" + titAMostrar + "); \n");
            }
            return true;
        } else if (line.contains(LEER) || line.contains(LEER.toLowerCase())) {
            String titALeer = line.substring(getPositionOf(LEER, line) + LEER.length(), getPositionOf(")", line));
            if (titALeer.contains(",")) {
                String[] vars = titALeer.split(",");
                for (int i = 0; i < vars.length; i++) {
                    writer.write(vars[i] + " = sc.next" + getTypeForInput(vars[i].trim()) + "();\n");
                }
            } else {
                writer.write(titALeer + " = sc.next" + getTypeForInput(titALeer) + "();\n");
            }
            return true;
        } else if (line.contains(":=") && !line.contains(PARA)) {
            String[] assigns = line.split(":=");
            writer.write(assigns[0].trim() + SPACE + "=" + SPACE + assigns[1].trim() + ";\n");
            return true;
        }
        return false;
    }

    private static String getTypeForInput(String var) {
        if (theVariables.get(var).equalsIgnoreCase("String")) {
            return "";
        }
        String name = theVariables.get(var);
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(0, 1).toUpperCase());
        sb.append(name.substring(1).toLowerCase());
        return sb.toString();
    }


}

class JavaSourceFromString extends SimpleJavaFileObject {
    private final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}
